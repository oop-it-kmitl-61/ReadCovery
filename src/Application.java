import org.json.*;

import java.util.ArrayList;

public class Application {
    private JSONArray data_pool;
    private ArrayList<String> selects;
    private ArrayList<String> saveList;
    private int random, maxBound;

    public int getRandom(){
        maxBound--;
        this.selects.remove(this.random);
        return (int)Math.random() * maxBound + 1;
    }
    public Application(ArrayList<String> arr){
        this.selects = arr;
        this.maxBound = this.selects.size();
        this.random = getRandom();
        this.saveList = new ArrayList<>();
    }

    public ArrayList<String> saveList(){
        if(this.saveList.size() == 0){
            return null;
        }
        return this.saveList;
    }
    public String next(){
        this.random = getRandom();
        if(this.random > 0){
            return selects.get(this.random);
        }
        return null;
    }
    public void save(){
        saveList.add(selects.get(this.random));
        this.random = getRandom();
    }
}
