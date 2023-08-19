package tech.parkhurst.restapi.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.parkhurst.restapi.utils.ScrapeUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.rmi.server.LogStream.log;

@Component
public class MatchCollectionService {

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
            Elements resultElements = doc.select(".result");

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

                // Print or process the extracted information
                System.out.println("Team 1: " + team1);
                System.out.println("Team 2: " + team2);
                System.out.println("Score: " + scoreLost + " - " + scoreWon);
                System.out.println("Event Name: " + eventName);
                System.out.println("Map: " + map);
                System.out.println("====================");
            }




//            Elements rows = doc.select("div.result-con");
//            //Successful ways to get data of  doc.select("div.result-con");
//            //doc.select("a.a-reset").forEach(System.out::println);
//            //System.out.println(row.child(0).text());
//            ArrayList<String> rawStringDataList = new ArrayList<String>();
//            for(Element row : rows){
////                Element link = row.select("a").first();
////                System.out.println(link.text());
////                System.out.println(link.attr("href"));//split by / and tempList[2] seems good
//                Element resultTableRow = row.select("tr").first();
//                Elements resultTableCols = resultTableRow.select("td");
//                int team=0;
//                for (Element col: resultTableCols){
//                    //System.out.print(temp.text()+"____");
//                    if(col.className().equals("team-cell") && team==0){
//                        System.out.print(col.text()+" A ");
//                        team+=1;
//                    }else if(col.className().equals("team-cell") && team==1){
//                        System.out.println(col.text()+" B ");
//
//                    }else if(col.className().equals("result-score")){
//                        System.out.print(col.text()+" ");
//                    }
//                    /**TODO: Next is to break down each  column and verify correct mapping
//                     *  Challenge will be regarding team-cell and team-cell verifying
//                     *  not only keep values consistent but also correct with score
//                     */
//                    /**
//                     * self.soup.find_all("div", class_="line-align team1"),
//                     * self.soup.find_all("div", class_="line-align team2"),
//                     *self.soup.find_all("div", class_="team team-won")):
//                     * wont work team-won was removed(assholes)
//                     */
//                    //first one found is teama and second is teamb & similar to score discovered
//
//                }
//                System.out.println("NEXT ROW");
//                //System.out.println(test.text());
//
//
//                System.out.println("-");
//            }

            //Elements newsHeadlines = doc.select("#mp-itn b a");
        }catch (Exception e){
            System.out.println("Shit Failed");
            System.out.println(e.toString());
        }
    }



}
