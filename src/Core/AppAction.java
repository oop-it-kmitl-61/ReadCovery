package Core;

import org.json.*;

import java.util.ArrayList;
import java.util.HashMap;
/*
* each news in newsList is Hashmap
* Structure like this
* Hashmap<String,String>
* have 3 type
* key => value
* "title" => "Title of news"
* "url" => "Website Url"
* "urlToImage" => "urlToimg"
* See more at method getData@ApiUtil
* */

public class AppAction {
    private ArrayList<HashMap> newsList;

    private static AppAction INSTANCE;

    public AppAction(){

    }
    public AppAction(ArrayList<HashMap> arr){
        this.newsList = arr;

    }
    public static AppAction getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AppAction();
        }
        return INSTANCE;
    }

    public void setNewsList(ArrayList<HashMap> newsList) {
        this.newsList = newsList;
    }
}
