package Core;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.json.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final String API ="3249e937bdde4f27bc283ab7219b1142";

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
//        String[] select = new String[2];
//        select[0] = "business";
//        select[1] = "science";
//        JSONArray data = api.getSelectedArticles(select);
////        ArrayList<String> titles = api.getArticleTitle(data);
//        ArrayList<HashMap> apiData = api.getData(data);
//        AppAction app = AppAction.getInstance();
//        app.setNewsList(apiData);
//
//        System.out.println(app.getCurrent());
//        app.next();
//        System.out.println(app.getCurrent());
//        app.previous();
//        System.out.println(app.getCurrent());
//        app.save();
//
//        app.next();
//        System.out.println(app.getCurrent());
//        app.save();
//        System.out.println(app.getsaveBox());



//        String[] a = new String[10];
//        a[0]="Business";
//        Boolean res = ApiUtil.regisRequest("sss","eieie","123","Business");

            String res = ApiUtil.loginRequest("sss", "123");
        ApiUtil.setToken(res);
        System.out.println(ApiUtil.getToken());

    }
}
