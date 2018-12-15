package Core;

import org.json.*;

import java.util.ArrayList;
import java.util.HashMap;

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
