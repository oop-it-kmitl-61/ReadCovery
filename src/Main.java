import org.json.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String API ="3249e937bdde4f27bc283ab7219b1142";
    private static ApiUtil api;
    private static JSONArray articles;
    private static JSONArray data_pool;

    public static void main(String[] args)throws Exception{
//        api = new ApiUtil(API);
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
        ArrayList<String> titles = api.getArticleTitle(data);
        Application app = new Application(titles);
        int act;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("================================");
            System.out.println("| Save List                    |");
            ArrayList<String> temp = app.saveList();
            if(temp != null) {
                for (int i = 0; i < temp.size(); i++) {
                    System.out.println(temp.get(i));
                }
            }
            System.out.println("--------------------------------\n");
            System.out.println("[1] Next\t[2] Read\t[3] Save");
            act = Integer.parseInt(sc.nextLine());
            if(act == 1){
                System.out.println(app.next());
            }
            if(act == 2){
                app.save();

            }
//            System.out.println("================================");
        }

    }
}
