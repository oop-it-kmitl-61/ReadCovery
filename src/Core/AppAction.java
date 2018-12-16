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
    private ArrayList<HashMap> prevStack = new ArrayList<>();
    private Random rand = new Random();
    private static AppAction INSTANCE;
    private HashMap current;
    private HashMap<String, String> saveBox = new HashMap<>();
    private HashMap<String, String> readBox = new HashMap<>();
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
        int randomIndex = rand.nextInt(newsList.size());
        this.current = newsList.get(randomIndex);
        newsList.remove(current);
    }

    public void next(){
        newsList.remove(current);
        int randomIndex = rand.nextInt(newsList.size());
        HashMap random = newsList.get(randomIndex);
        prevStack.add(current);
        this.current = random;
        newsList.remove(randomIndex);
    }
    public boolean previous(){
        if(prevStack.size() > 0){
            HashMap response = prevStack.get(prevStack.size()-1);
            this.current = response;
            prevStack.remove(prevStack.size()-1);
            return true;
        }return false;
    }
    public void save(){
        newsList.remove(current);
        saveBox.put(current.get("title").toString(), current.get("url").toString());
    }
    public void read(String title, String url){
        readBox.put(title, url);
    }
    public ArrayList<HashMap> getNewsList(){
        return this.newsList;
    }

    public HashMap getCurrent(){
        return this.current;
    }

    public HashMap getreadBox(){
        return this.readBox;
    }
    public HashMap getsaveBox(){
        return this.saveBox;
    }
}
