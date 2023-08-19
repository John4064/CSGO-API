package tech.parkhurst.restapi.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.parkhurst.restapi.utils.ScrapeUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.rmi.server.LogStream.log;


@Component
public class MatchCollectionService {

    private static final String baseUrl="https://www.hltv.org";
    private Document doc;
    private int totalMatches;

    public int gatherSize() throws IOException{
        Element masthead = doc.select("span.pagination-data").first();
        String[] splited = masthead.text().split(" ");
        try{
            return Integer.parseInt(splited[splited.length-1]);
        }catch (Exception e){
            System.out.println("Unable to convert string to integer upon gathering size");
            System.out.println(e.toString());
            return -1;
        }
    }

    public void gatherTeamData() throws IOException{

    }
    public void deadCodeUselessTest()throws IOException{
        ArrayList<String> urlList =ScrapeUtils.generateUrls(totalMatches);
        ArrayList<Integer> countList = new ArrayList<>();
        int a =0;
        for (String url : urlList){
            doc = Jsoup.connect(url)
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Referrer Policy","strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
            Elements tempRows = doc.select("div.result-con");
            countList.add(tempRows.size());
            System.out.println("Another One COmplete"+a);
            a+=1;
        }

        for (int x = 0; x<countList.size();x++){
            System.out.println(countList.get(x));
            if(countList.get(x) != 100){
                System.out.println("THE INDEX IS "+x);
            }
        }
        return;
    }

    @PostConstruct
    public void init() throws IOException {
        System.out.println("GATHER STATISTICS");
        try{
            doc = Jsoup.connect("https://hltv.org/results")
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Referrer Policy","strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
            totalMatches=gatherSize();
            ArrayList<String> urlList =ScrapeUtils.generateUrls(totalMatches);
            // Select all elements with class "result"
            Elements resultElements = doc.select(".result-con");
            int a =0;
            for (Element resultElement : resultElements) {
                // Get team names
                String team1 = resultElement.select(".team1 .team").text();
                String team2 = resultElement.select(".team2 .team").text();

                // Get scores
                String scoreLost = resultElement.select(".result-score .score-lost").text();
                String scoreWon = resultElement.select(".result-score .score-won").text();

                // Get event name
                String eventName = resultElement.select(".event-name").text();

                // Get map
                String map = resultElement.select(".map-text").text();

                //Gather Href
//
                String href = resultElement.select("a.a-reset").attr("href");

                // Print or process the extracted information
                System.out.println("Team 1: " + team1);
                System.out.println("Team 2: " + team2);
                System.out.println("Score: " + scoreLost + " - " + scoreWon);
                System.out.println("Event Name: " + eventName);
                System.out.println("Map: " + map);
                System.out.println("URL: "+baseUrl+href);
                System.out.println("COUNT: "+a);
                System.out.println("====================");
                a++;
            }
        }catch (Exception e){
            System.out.println("Shit Failed");
            System.out.println(e.toString());
        }
    }



}
