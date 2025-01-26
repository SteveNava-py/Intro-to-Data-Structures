/*package webCrawler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.List;

public class SearchFrame extends JFrame {
    //set bounds as img size
    final int SCREEN_LENGTH = 890;
    final int SCREEN_WIDTH = 1280;

    //create instance of spider class
    Spider spider = new Spider();

    //shows 1-10 combo box option
    public JComboBox comboBox;

    //webCrawler.DisplayPanel will show links and frequencies
    DisplayPanel displayPanel = new DisplayPanel();

    //cardLayout switches between searchDisplayScreen and webCrawler.DisplayPanel
    CardLayout cardLayout = new CardLayout();

    //counts amount of words separated by " "
    private int count= 0;

    //first displayscreen
    JLayeredPane searchDisplayScreen;


    JLabel label, labelPanel, pageLabel;

    //text input
    public JTextField textField;

    //checks if search has gone through in order to execute next cardlayout
    public static boolean searchOn = false;


    JButton searchBtn;
    ImageIcon background;
    SearchFrame(){


        this.setSize(SCREEN_WIDTH, SCREEN_LENGTH);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setTitle("Search Engine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //creates first label which is the background
        label = new JLabel();
        label.setOpaque(false);
        label.setVisible(true);
        background = new ImageIcon("src/global-6635477_1280.png");
        label.setIcon(background);
        label.setFocusable(false);
        label.setBounds(0,0,1280,890);

        //second label displays "Search Engine"
        labelPanel = new JLabel("Search Engine");
        labelPanel.setVisible(true);
        labelPanel.setForeground(Color.white);
        labelPanel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        labelPanel.setOpaque(false);
        labelPanel.setBounds(470,300,500,100);

        //third label displays "Max 'Or' Page Search"
        pageLabel = new JLabel("Max 'Or' Page Search");
        pageLabel.setVisible(true);
        pageLabel.setForeground(Color.black);
        pageLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        pageLabel.setOpaque(false);
        pageLabel.setBounds(370,420,400,75);


        //combo box will store a list of integers
        Integer[] num = {1,2,3,4,5,6,7,8,9,10};
        comboBox = new JComboBox<>(num);
        comboBox.setVisible(true);
        comboBox.setBounds(650,445,60,25);
        comboBox.setBackground(Color.darkGray);
        comboBox.setFont(new Font("Times New Roman",Font.BOLD,18));
        comboBox.setForeground(Color.white);

        //gives actionlistener to combobox in order to give functionality
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Option picked will be assigned to max page search in webCrawler.Spider Class
                if (e.getSource()==comboBox){
                    Spider.MAX_PAGES_TO_SEARCH = (int) comboBox.getSelectedItem();
                }
            }
        });

        textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arabic Typesetting", Font.ITALIC, 20));
        textField.setVisible(true);
        textField.setFocusable(true);
        textField.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        textField.setBounds(380,400,380,25);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                //integer key code of "Enter" is 10. When pressed will read text and check the amount of words separated by " " and counted by counter
                if(String.valueOf(e.getKeyCode()).contentEquals("10")){
                    for (int i = 0; i< textField.getText().length();i++){
                        if(String.valueOf(textField.getText().charAt(i)).contentEquals(" ")){
                            count++;
                        }
                    }
                    //if there is no text will prompt user to try again
                    if(textField.getText().contentEquals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Something!", "Try Again", JOptionPane.ERROR_MESSAGE);
                        count = 0;
                        // if word count exceeds 3 prompts user to try again
                    }else if(count > 2){
                        JOptionPane.showMessageDialog(null, "Only 3 words allowed.", "Try Again", JOptionPane.ERROR_MESSAGE);
                        count = 0;

                    }
                    //instance where there are 3 words and success
                    else{
                        //Will commence the spider search starting at "http://www.hc.edu". Surrounded by try and catch to account for file exception when
                        //"stopwords.txt" is eventually read
                        try {
                            spider.search("http://www.hc.edu", textField.getText());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        //next Cardlayout is called to display the next page
                        setCardLayout();


                    }

                }

            }
        });


        searchBtn = new JButton();
        searchBtn.setBackground(Color.white);
        searchBtn.setText("Search");
        searchBtn.setFocusable(true);
        searchBtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
        searchBtn.setVisible(true);
        searchBtn.setBackground(Color.gray);
        searchBtn.setBounds(760,395,90,35);
        searchBtn.setBorder(BorderFactory.createLineBorder(Color.black, 2, false));

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Same as previous actionListener using "Enter" key but will also take input as the search button
                if (textField.getText().contentEquals("")){
                    JOptionPane.showMessageDialog(null, "Enter Something!","Try Again", JOptionPane.ERROR_MESSAGE);

                }else{
                    for (int i = 0; i< textField.getText().length();i++){
                            if(String.valueOf(textField.getText().charAt(i)).contentEquals(" ")){
                                count++;
                            }
                        }
                    if(count>2) {
                        JOptionPane.showMessageDialog(null, "Only 3 words allowed.", "Try Again", JOptionPane.ERROR_MESSAGE);
                        count = 0;
                    }else{
                        count = 0;
                        try {
                            spider.search("http://www.hc.edu", textField.getText());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        setCardLayout();

                    }
                }

            }
        });



        searchDisplayScreen = new JLayeredPane();
        searchDisplayScreen.setBounds(0,0,1280,890);
        searchDisplayScreen.setLayout(null);

        searchDisplayScreen.add(labelPanel, JLayeredPane.PALETTE_LAYER);

        //Default_Layer gets less priority since it is the background
        searchDisplayScreen.add(label, JLayeredPane.DEFAULT_LAYER);


        searchDisplayScreen.add(textField, JLayeredPane.PALETTE_LAYER);
        searchDisplayScreen.add(searchBtn, JLayeredPane.PALETTE_LAYER);
        searchDisplayScreen.add(comboBox, JLayeredPane.PALETTE_LAYER);
        searchDisplayScreen.add(pageLabel, JLayeredPane.PALETTE_LAYER);
        searchDisplayScreen.revalidate();
        searchDisplayScreen.repaint();


        //adds first display card
        this.add(searchDisplayScreen);

        this.setLocationRelativeTo(null);

        searchDisplayScreen.setVisible(true);
        this.setVisible(true);








    }
    //when search is successful this method will be called
    private void setCardLayout(){

        //removes everything on the current page
        this.searchDisplayScreen.removeAll();
        //will add next page
        this.add(displayPanel);
        //gives both cardlayout to switch between
        displayPanel.setLayout(cardLayout);
        searchDisplayScreen.setLayout(cardLayout);

        //Will now show the next page
        cardLayout.show(displayPanel, "Display Panel");
        cardLayout.next(displayPanel);
        searchOn = true;
        displayPanel.revalidate();
        displayPanel.repaint();

        //Deserializes hashmap wordFrequencies from webCrawler.SpiderLeg class
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("wordFrequencies.ser"))) {
            //new hashmap casts deserialized object to hashmap and stores it
            HashMap<String, Integer> deserializedMap = (HashMap<String, Integer>) ois.readObject();

            //Stores HashMap in arraylist as entry set which stores keys and values. Stored in list because hashmaps do not maintain order. Map.Entry is a interface that allows
            //extraction of both values and keys
            List<Map.Entry<String, Integer>> list = new ArrayList<>(deserializedMap.entrySet());

            //sorts list using implementation of insertion sort with comparator interface that compares integer values from the mapentry value
            //chose insertion sort because it is a small dataset; even though it is O(n^2) comparisons it will not have to create extra memory with other sort methods
            //and also is just limited to 10 elements. It does high number of comparisons best case n but does not do many swaps best case 1 worst case O(n)
            insertionSort(list, Comparator.comparingInt(Map.Entry::getValue));


            //StringBuilder concatenates all given values as strings
            StringBuilder sb = new StringBuilder();
            //iterates through the whole list and appends keys and values to the stringbuilder.
            for (Map.Entry<String, Integer> entry : list) {
                sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");

            }
            // Display the sorted key-value pairs in the JTextArea
            displayPanel.jTextArea.setText(sb.toString());



        } catch (IOException | ClassNotFoundException e) {

        }






    }
    public static <T> void insertionSort(List<T> list, Comparator<? super T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            //key is the value that will be compared in order for replacing
            T key = list.get(i);
            //j will be start at the index prior to i for comparison
            int j = i - 1;

            // Shift elements of the sorted portion of the list to the right
            //having key first reverses logic, instead will check if key is greater than value being compared
            while (j >= 0 && comparator.compare(key, list.get(j)) > 0) {
                //while j has not gone out of bounds and key is greater than j shift elements to right to make room for key
                list.set(j + 1, list.get(j));
                //decrement our position in j
                j--;
            }
            // Place the key in the correct position
            list.set(j + 1, key);
        }
    }
}
*/