package Core;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.CDL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ApiUtil {
    private static String API = "&apiKey="+"3249e937bdde4f27bc283ab7219b1142";
    private static String cat = "business";
    private static String base_url = "https://newsapi.org/v2/top-headlines?country=us&category=";
    private static String url = base_url+cat+API;
    private static HttpURLConnection con;
    private static StringBuilder content;

    public ApiUtil(){

    }


    public static JSONObject callAPI()throws MalformedURLException, ProtocolException, IOException {
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
//            System.out.println(content.toString());
            return strToJson(content.toString());

        }finally {
            con.disconnect();
        }


    }
    public static JSONObject strToJson(String s){
        JSONObject jo = new JSONObject(s);
        return jo;
    }

    public static void setCat(String cat){
        cat = cat;
        url = base_url+cat+API;
    }

    public static JSONArray getSelectedArticles(String[] cats) throws Exception{
        JSONArray artPool = new JSONArray();
        for(int i =0;i< cats.length;i++){
            cat = cats[i];
            artPool.put(callAPI().getJSONArray("articles"));
        }
        return artPool;
    }
    public static ArrayList<HashMap> getData(JSONArray ja){
        ArrayList<HashMap> temp = new ArrayList<>();

        for(int i=0;i<ja.length();i++){
            for(int j = 0;j<ja.getJSONArray(i).length();j++){
                HashMap<String, String> data = new HashMap<>();
                data.put("title", ja.getJSONArray(i).getJSONObject(j).getString("title"));
                data.put("url", ja.getJSONArray(i).getJSONObject(j).getString("url"));
                data.put("urlToImage", ja.getJSONArray(i).getJSONObject(j).get("urlToImage").toString());
                temp.add(data);
            }
        }
        return temp;
    }
    public static ArrayList<String> getArticleTitle(JSONArray ja){
        ArrayList<String> temp = new ArrayList<>();

        for(int i=0;i<ja.length();i++){
            for(int j = 0;j<ja.getJSONArray(i).length();j++){
                temp.add(ja.getJSONArray(i).getJSONObject(j).getString("title"));
//                System.out.println(ja.getJSONArray(i).getJSONObject(j).getString("title"));
            }
        }
        return temp;
    }
}
