package webCrawler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class SpiderLeg implements Serializable {
    public static int counter = 0;
    //This is the decent polite way of doing this!!
    private static final String USER_AGENT = "COSC 2351 testing crawler (hbu.edu)";

    //stores every link
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;
    private static Map<String, Integer> wordFrequencies = new HashMap<>();



    public boolean crawl(String url) {
        try {
            Thread.sleep(100);
            //establishing jsoup connection
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            //retrieves html document
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            if (connection.response().statusCode() != 200) // 200 is the HTTP OK status code
            // indicating that everything is great.
            {
                return false;
            }
            //means it is a html text file
            if (!connection.response().contentType().contains("text/html")) {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            //retrieves hyperlinks found in html doc stored in object Elements
            Elements linksOnPage = htmlDocument.select("a[href]");
            for (Element link : linksOnPage) {
                //adds entire absolute url whole path if not added already
                this.links.add(link.absUrl("href"));
            }
            return true;
        }catch (IOException ioe){
            //not succsessful in http request
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean searchForWord(String searchWord, String currentUrl) throws IOException {
        //Method is used when crawl has succeeded.
        if (this.htmlDocument == null) {
            System.out.println("Error! call crawl() first.");
            return false;
        }
        String bodyText = this.htmlDocument.body().text();
        //if bodytext is not empty
        if (bodyText != null) {
            //sets file of stopwords
            String filePath = "src/webCrawler/stopwords.txt";

            //splits every word from text input
            String[] eachSearchWord = searchWord.split(" ");

            //splits every word in the text being searched
            String[] bodyTextWords = bodyText.split(" ");

            //Reads string in stopwords.txt and stores in string value
            String fileContent = Files.readString(Path.of(filePath));

            //splits every word in stopwords.txt by line
            String[] stopwordLines = fileContent.split("\n");

            //method to remove all stopwords from body text
            bodyTextWords = removeStopWords(bodyTextWords, stopwordLines);

            //methods to add urls and frequencies to hash map
            wordFrequencies = createHashMap(wordFrequencies, bodyTextWords, eachSearchWord, currentUrl);
            counter++;

            //when counter increments to the maximum pages searched now hash map can be serialized
            if (counter==Spider.MAX_PAGES_TO_SEARCH) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("wordFrequencies.ser"))) {
                    oos.writeObject(wordFrequencies);  // Write the HashMap to a file
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

                return bodyText.toLowerCase().contains(searchWord.toLowerCase());



            }
            return false;

        }

        public String[] removeStopWords(String[] bodyTextWords, String[] stopwordLines){
            // Convert stopwordLines to a Set for O(1) lookup instead of iterating through it which is O(N). reduced complexity from O(n^2) to O(n)
            Set<String> stopwordsSet = Arrays.stream(stopwordLines).map(String::toLowerCase).collect(Collectors.toSet());
            //iterate through list of bodytextwords and remove if equal to a key in stopwordsSet
            for (int i = 0; i < bodyTextWords.length; i++) {
                String lowerCaseWord = bodyTextWords[i].toLowerCase();
                if (stopwordsSet.contains(lowerCaseWord)) {
                    bodyTextWords[i] = ""; // Replace stopword with an empty string
                }
            }

            return bodyTextWords;
        }

    public static Map<String, Integer> createHashMap(Map<String, Integer> wordFrequencies, String[] bodyTextWords, String[] eachSearchWord ,String currentUrl) {
        // Convert eachSearchWord to a Set for O(1) lookup instead of iterating through it which is O(N). reduced complexity from O(n^2) to O(n)
        Set<String> searchWordsSet = Arrays.stream(eachSearchWord).map(String::toLowerCase).collect(Collectors.toSet());

        // Iterate through bodyTextWords once and compare to searchword set
        for (String word : bodyTextWords) {
            //converts word to lower case for accurate comparison
            String lowerCaseWord = word.toLowerCase();
            if (searchWordsSet.contains(lowerCaseWord) && !lowerCaseWord.isEmpty()) {
                Integer freq = wordFrequencies.get(currentUrl);
                wordFrequencies.put(currentUrl, freq == null ? 1 : freq + 1);            }
        }
        return wordFrequencies;
    }

    public List<String> getLinks () {
            return this.links;
        }

}
