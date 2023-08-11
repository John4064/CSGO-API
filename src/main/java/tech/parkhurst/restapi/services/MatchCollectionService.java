package tech.parkhurst.restapi.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.rmi.server.LogStream.log;

@Component
public class MatchCollectionService {


    @PostConstruct
    public void init() throws IOException {
        System.out.println("GATHER STATISTICS");

        try{
            Document doc = Jsoup.connect("https://hltv.org/")
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Referrer Policy","strict-origin-when-cross-origin")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/115.0")
                    .referrer("http://www.google.com")
                    .get();
            System.out.println(doc.title());
            //Elements newsHeadlines = doc.select("#mp-itn b a");
        }catch (Exception e){
            System.out.println("Shit Failed");
            System.exit(32);
        }
    }



}
