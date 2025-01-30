package webCrawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {
    public static int MAX_PAGES_TO_SEARCH = 1;
    //new page stored, set so uniquely identified values
    private Set<String> pagesVisited = new HashSet<String>();
    //stores every url
    private List<String> pagesToVisit = new LinkedList<String>();

    public void search(String url, String searchWord) throws IOException {
        //first url given by user added to list
       String currentUrl;
       this.pagesToVisit.add(url);
       //limits page search
       while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH){
           //creates instance of crawler
           SpiderLeg leg = new SpiderLeg();
           if (this.pagesToVisit.isEmpty()) {
               break;
           } else {
               currentUrl = this.nextURL();
           }
           //takes current url to SpiderLeg and parses data
           leg.crawl(currentUrl);
           leg.searchForWord(searchWord, currentUrl);

        this.pagesToVisit.addAll(leg.getLinks()); //all links that had the words queried will be added to pages visited from searchForWord
       }

    }
    private String nextURL(){
    String nextUrl;
    do{
        //checks hashset if url has been seen it will not be read
        nextUrl = this.pagesToVisit.remove(0);
    } while (this.pagesVisited.contains(nextUrl));
        //add to pages visited
        this.pagesVisited.add(nextUrl);
        //return new url
        return nextUrl;

    }

}
