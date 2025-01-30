package webCrawler;

import javax.swing.*;
import java.awt.*;


public class DisplayPanel extends JLayeredPane {
    //set bounds as img size
    final int SCREEN_LENGTH = 890;
    final int SCREEN_WIDTH = 1280;
    public JScrollPane jScrollPane;
    public JTextArea jTextArea;
    public JPanel background = new JPanel(null);


    DisplayPanel() {
        this.setSize(SCREEN_WIDTH, SCREEN_LENGTH);
        this.setBackground(new Color(100,0,0));

        background.setVisible(true);
        background.setBounds(0,0,SCREEN_WIDTH,SCREEN_LENGTH);
        background.setBackground(new Color(0,0,40));

        jTextArea = new JTextArea(25, 40);
        jTextArea.setVisible(true);
        jTextArea.setEditable(false);
        jTextArea.setText("");
        jTextArea.setBackground(Color.darkGray);
        jTextArea.setForeground(Color.white);
        jTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jTextArea.setLineWrap(true);

        jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setBounds(200,0,SCREEN_WIDTH-400,SCREEN_LENGTH);
        jScrollPane.setBorder(BorderFactory.createLineBorder(Color.black,2,false));
        jScrollPane.getVerticalScrollBar().setBackground(Color.black);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        background.add(jScrollPane);
        this.add(background, JLayeredPane.PALETTE_LAYER);
        jTextArea.setMargin(new Insets(10,10,10,10));

        this.setVisible(true);

    }

}
