import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

//this class has the metrics
public class DailyResults {

    int maxPercentageHumidity;
    int maxTemp;
    int minTemp;
    float precipitation;

    DailyResults(){
    }

    //connect with the url and read the metrics from the json
    public DailyResults Calculate(SearchInfo info){

        String urlString="http://api.wunderground.com/api/"+info.getApiKey()+"/history_"+info.getDay()+"/q/NY/"+info.getCity()+".json";
        try{
            Object tempObject;
            JSONObject object;

            JSONParser jsonParser = new JSONParser();
            URL url = new URL(urlString);

            //connect
            InputStream in = new URL(urlString).openStream();

            //scan the json
            java.util.Scanner scanner = new java.util.Scanner(in).useDelimiter("\\A");

            //take the object
            tempObject = jsonParser.parse(scanner.next());
            object = (JSONObject) tempObject;

            //get the daily summary where is the information that we need
            JSONArray jsonArray  = (JSONArray) ((JSONObject) object.get("history")).get("dailysummary");

            //there is only one so we get the 0
            JSONObject dailySummary = (JSONObject) jsonArray.get(0);


            this.maxPercentageHumidity = Integer.parseInt((String)dailySummary.get("maxhumidity"));
            this.maxTemp= Integer.parseInt((String)dailySummary.get("maxtempm"));
            this.minTemp = Integer.parseInt((String)dailySummary.get("mintempm"));
            this.precipitation = Float.parseFloat((String)dailySummary.get("precipm"));



        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public void writeFile(){
        try{
            PrintWriter writer = new PrintWriter("metrics.txt", "UTF-8");
            writer.println("The max humidity is "+maxPercentageHumidity);
            writer.println("The max temperature is "+maxTemp);
            writer.println("The min temperature is "+minTemp);
            writer.println("The precipitation is "+precipitation);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}