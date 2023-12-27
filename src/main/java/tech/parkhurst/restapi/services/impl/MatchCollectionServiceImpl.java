package tech.parkhurst.restapi.services.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tech.parkhurst.restapi.entities.HltvMatch;
import tech.parkhurst.restapi.utils.ScrapeUtils;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;


@Service
public class MatchCollectionServiceImpl {


    @Autowired
    private MatchServiceImpl matchServicesImpl;

    private static final Logger logger = LoggerFactory.getLogger(MatchCollectionServiceImpl.class);

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


    //Put logic of this service in an additional function that can be called. Cant be called outside of init because
    @Async
    @PostConstruct
    public void init() throws IOException {
        logger.info("Gathering new data!");

        gatherMatchData();
    }

    /**
     * @body gathers all the data for the teams table from hltv.org
     * @return nothing
     */
     public void gatherTeams() throws IOException{
        try{
            doc = Jsoup.connect("https://hltv.org/results")
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Referrer Policy","strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
        }catch(Exception e){
            logger.error("ERROR GATHERING TEAM DATA");
        }
        return;
    }

    public void gatherPlayers() throws IOException{
        try{
            doc = Jsoup.connect("https://hltv.org/results")
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Referrer Policy","strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
        }catch(Exception e){
            logger.error("ERROR GATHERING TEAM DATA");
        }
         return;
    }

    public void gatherMatchData() throws IOException{
        try{
            ArrayList<String> idList= (ArrayList<String>) matchServicesImpl.getIDList();
            doc = Jsoup.connect("https://hltv.org/results")
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Referrer Policy","strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
            totalMatches=gatherSize();
            ArrayList<String> urlList =ScrapeUtils.generateUrls(totalMatches);
            for(String url: urlList){
                doc = Jsoup.connect(url)
                        .header("Content-Type","application/x-www-form-urlencoded")
                        .header("Referrer Policy","strict-origin-when-cross-origin")
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                        .referrer("http://www.google.com")
                        .get();
                // Select all elements with class "result"
                Elements resultElements = doc.select(".result-con");
                int fetchedMatchCount = 0;
                for (Element resultElement : resultElements) {
                    // Get team names
                    String teamA = resultElement.select(".team1 .team").text();
                    String teamB = resultElement.select(".team2 .team").text();
                    String temp = resultElement.select(".result-score").text();//.score-won and .score-lost will be inaccurate
                    String[] testList =new String[2];
                    testList=temp.split(" - ");
                    int scoreTA=Integer.parseInt(testList[0]);
                    int scoreTB = Integer.parseInt(testList[1]);
                    // Get event name
                    String eventName = resultElement.select(".event-name").text();
                    // Get map
                    String mapType = resultElement.select(".map-text").text();
                    //Gather Href
                    String href = resultElement.select("a.a-reset").attr("href");
                    //Get ID
                    String matchID = href.split("/")[2];
                    //Quality check
                    if(fetchedMatchCount >= idList.size()){
                        logger.info("No more new matches detected;");
                        return;
                    }
                    fetchedMatchCount++;
                    HltvMatch tempMatch = new HltvMatch(matchID,teamA,teamB,baseUrl+href,scoreTA,scoreTB,eventName,mapType);
                    if(idList.contains(tempMatch.getMatchid())){
                        logger.info("No more new matches detected;");
                        return;
                    }else{
                        logger.info("Inserted new match with ID: "+tempMatch.getMatchid());
                        matchServicesImpl.createMatch(tempMatch);
                    }//2368724
                }
            }
        }catch (NumberFormatException ne){
            logger.error("Error converting the score ");
            logger.error(ne.toString());
        }catch (Exception e){
            logger.error("Generic Scraping Error");
            logger.error(e.toString());
        }
    }

}
