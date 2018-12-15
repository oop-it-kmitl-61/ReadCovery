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
        AppAction app = new AppAction(apiData);
        int act;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("================================");
            System.out.println("| Save List                    |");

            ArrayList<HashMap> temp = app.getSaveList();
            if(temp != null) {
                for (int i = 0; i < temp.size(); i++) {
                    System.out.println(temp.get(i).get("title"));
                }
            }
            System.out.println("--------------------------------");
            System.out.println("| Previous List                |");
            ArrayList<HashMap> prevList = app.getPrev();

                for (int i = 0; i < prevList.size(); i++) {
                    System.out.println(prevList.get(i).get("title"));
                }

            System.out.println("--------------------------------\n");
                System.out.println("Now: "+app.getNow());

            System.out.println("[1] Previous\t[2] Save\t[3] Next");
            act = Integer.parseInt(sc.nextLine());
            if(act == 1){
                app.prev();
            }
            if(act == 2){
                app.save();

            }
            if(act == 3){
                app.next();
            }
//            System.out.println("================================");
        }

    }
}
