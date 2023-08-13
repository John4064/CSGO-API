package tech.parkhurst.restapi.utils;
import java.util.ArrayList; // import the ArrayList class
public class ScrapeUtils {
    private static final String baseUrl="https://www.hltv.org/results?offset=%s";


    public static ArrayList<String> generateUrls(int totalMatchSize){
        ArrayList<String> urlList = new ArrayList<String>(); // Create an ArrayList object
        for (int x = 0; x<totalMatchSize;x+=100){
            System.out.println(x);
            urlList.add(String.format(baseUrl,x));
        }
        return urlList;
    }
}
