package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
    private ArrayList<HashMap> saveList = new ArrayList<>();
    private ArrayList<HashMap> prevStack = new ArrayList<>();
    private static AppAction INSTANCE;
    private HashMap current;

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
        Random rand = new Random();
        int randomIndex = rand.nextInt(newsList.size());
        this.current = newsList.get(randomIndex);
        newsList.remove(current);
    }

    public void next(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(newsList.size());
        HashMap random = newsList.get(randomIndex);
        prevStack.add(current);
        this.current = random;
        newsList.remove(randomIndex);
    }
    public void previous(){
        HashMap response = prevStack.get(prevStack.size()-1);
        this.current = response;
        prevStack.remove(prevStack.size()-1);
    }
    public void save(){
        saveList.add(current);
        newsList.remove(current);
    }

    public ArrayList<HashMap> getNewsList(){
        return this.newsList;
    }

    public HashMap getCurrent(){
        return this.current;
    }

    public ArrayList<HashMap> getsaveList(){
        return this.saveList;
    }
}
