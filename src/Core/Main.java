package Core;

import org.json.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final String API ="3249e937bdde4f27bc283ab7219b1142";
    private static ApiUtil api;
    private static JSONArray articles;
    private static JSONArray data_pool;

    public static void main(String[] args)throws Exception{
//        api = new Core.ApiUtil(API);
//        data_pool = new JSONArray();
//        System.out.println("======================");
//        api.setCat("business");
//        articles = api.getAllArticles();
//        for(int i=0;i<articles.length();i++){
//            System.out.println(articles.getJSONObject(i).getString("title"));
//        }
        String[] select = new String[2];
        select[0] = "business";
        select[1] = "science";
        JSONArray data = api.getSelectedArticles(select);
//        ArrayList<String> titles = api.getArticleTitle(data);
        ArrayList<HashMap> apiData = api.getData(data);
        AppAction app = AppAction.getInstance();
        app.setNewsList(apiData);
    }
}