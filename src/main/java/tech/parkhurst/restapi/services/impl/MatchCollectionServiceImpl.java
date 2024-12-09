package tech.parkhurst.restapi.services.impl;

import org.jsoup.HttpStatusException;
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
import tech.parkhurst.restapi.services.MatchCollectionService;
import tech.parkhurst.restapi.services.MatchService;
import tech.parkhurst.restapi.utils.ScrapeUtils;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static tech.parkhurst.restapi.constants.Constants.userAgents;

@Service
public class MatchCollectionServiceImpl implements MatchCollectionService {

    @Autowired
    private MatchService matchService;
    private static final Logger logger = LoggerFactory.getLogger(MatchCollectionServiceImpl.class);
    private static final String baseUrl = "https://www.hltv.org";
    private Document doc;
    private int totalMatches;

    public int parseSize() throws IOException {
        Element masthead = doc.select("span.pagination-data").first();
        assert masthead != null;
        String[] splited = masthead.text().split(" ");
        try {
            int resultCount = Integer.parseInt(splited[splited.length - 1]);
            return resultCount;
        } catch (Exception e) {
            System.out.println("Unable to convert string to integer upon gathering size");
            System.out.println(e);
            return -1;
        }
    }


    //Put logic of this service in an additional function that can be called. Cant be called outside of init because
    @Async
    @PostConstruct
    public void init() throws IOException {


        logger.info("Gathering new data!");

        gatherMatchData();
        logger.info("Match Data Gathered!");
//        gatherTeams();

    }

    /**
     * @return nothing
     * @body gathers all the data for the teams table from hltv.org
     */
    public void gatherTeams(){
        int rnd = new Random().nextInt(userAgents.length);
        try {
            ArrayList<Integer> years = new ArrayList<>(List.of(2012));
            int tempYear = years.get(0) + 1;
            while (tempYear != Year.now().getValue() + 1 && !years.contains(tempYear)) {
                years.add(tempYear);
                tempYear += 1;
            }
            logger.warn("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0");
            doc = Jsoup.connect("https://www.hltv.org/stats/teams?startDate=2023-01-01&endDate=2023-12-31")
                    .header("content-type","application/x-www-form-urlencoded")
                    .header("Referrer Policy", "strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("https://www.google.com/")
                    .get();
//            for(Integer year: years){
//                logger.info(year.toString());
//            }
        } catch(HttpStatusException e) {
            //Todo: Setup try catch inside for loop to allow for retries for this specific error
            logger.error("HttpStatusError- User Agent: "+userAgents[rnd]);
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("ERROR GATHERING TEAM DATA");
            logger.error(e.getMessage());
        }
    }

    public void gatherPlayers() {
        try {
            doc = Jsoup.connect("https://hltv.org/results")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Referrer Policy", "strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
        } catch (Exception e) {
            logger.error("ERROR GATHERING TEAM DATA");
        }
    }

//    public ArrayList<String> gatherMatchCount(){
//
//    }

    public void gatherMatchData(){
        int rnd = new Random().nextInt(userAgents.length);
        final long startTime = System.currentTimeMillis();
        try {
            ArrayList<String> idList = (ArrayList<String>) matchService.getIDList();
            doc = Jsoup.connect("https://hltv.org/results")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Referrer Policy", "strict-origin-when-cross-origin")
                    .userAgent(userAgents[rnd])
                    .referrer("http://www.google.com")
                    .get();
            totalMatches = parseSize();
            int matchDbCount = matchService.getMatchCount();
            if(totalMatches==matchDbCount){
                logger.info("No New Matches: "+String.valueOf(totalMatches)+"-"+String.valueOf(matchDbCount));
                return;
            }
            ArrayList<String> urlList = ScrapeUtils.generateUrls(totalMatches);
            logger.info("SIZE: {}", urlList.size());
            ArrayList<HltvMatch> matches =new ArrayList<HltvMatch>(); // Cr
            Integer count =0;
            //Todo: Remove 129 figure out bug
//            urlList.remove(urlList.size()-1);
            for (String url : urlList) {
                try {
                    doc = Jsoup.connect(url)
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .header("Referrer Policy", "strict-origin-when-cross-origin")
                            .userAgent(userAgents[rnd])
                            .referrer("http://www.google.com")
                            .get();
                }catch (Exception e){
                    logger.error("Skipped URL: {}", url);
                    continue;
                }
                // Select all elements with class "result"
                Elements resultElements = doc.select(".result-con");
                for (Element resultElement : resultElements) {
                    // Get team names
                    String teamA = resultElement.select(".team1 .team").text();
                    String teamB = resultElement.select(".team2 .team").text();
                    String temp = resultElement.select(".result-score").text();//.score-won and .score-lost will be inaccurate
                    String[] testList = new String[2];
                    testList = temp.split(" - ");
                    int scoreTA = Integer.parseInt(testList[0]);
                    int scoreTB = Integer.parseInt(testList[1]);
                    // Get event name
                    String eventName = resultElement.select(".event-name").text();
                    // Get map
                    String mapType = resultElement.select(".map-text").text();
                    //Gather Href
                    String href = resultElement.select("a.a-reset").attr("href");
                    //Get ID
                    String matchID = href.split("/")[2];
                    //Todo: Move out of for loops
                    //Quality check
                    HltvMatch tempMatch = new HltvMatch(matchID,teamA,teamB,baseUrl+href,scoreTA,scoreTB,eventName,mapType);
                    if(idList.contains(tempMatch.getMatchid())){
                        logger.info("Existing match found- No more new matches detected;");
                        return;
                    } else {
                        matches.add(tempMatch);
                    }
                }
            }
            final long endTime = System.currentTimeMillis();
            //read time vs insert time
            //restart timer here
            logger.info("Saving {} Number of Matches",matches.size());
            logger.info("HLTV-Match read time took {} seconds", ((endTime-startTime)/1000) %60);
            matchService.insertMatches(matches);
        } catch (NumberFormatException ne) {
            logger.error("Error converting the score ");
            logger.error(ne.toString());
        } catch(HttpStatusException e) {
            //Todo: Setup try catch inside for loop to allow for retries for this specific error
            logger.error("HttpStatusError- User Agent: "+userAgents[rnd]);
            logger.error(e.getMessage());
        }catch (Exception e) {
            logger.error("Generic Scraping Error");
            logger.error(e.toString());
        }
    }

}
