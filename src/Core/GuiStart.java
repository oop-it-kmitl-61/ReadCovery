package Core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiStart extends Application{
    private static final String API ="3249e937bdde4f27bc283ab7219b1142";
    private static ApiUtil api;
    private static JSONArray articles;
    private static JSONArray data_pool;
    public AppAction app;
    @Override
    public void start(Stage stage) throws Exception {
        String[] select = new String[2];
        select[0] = "business";
        select[1] = "science";
        JSONArray data = api.getSelectedArticles(select);
        ArrayList<HashMap> apiData = api.getData(data);
        app = AppAction.getInstance();
        app.setNewsList(apiData);
//        app.setSelects(apiData);
//        app.prepInstance();
        Parent root = FXMLLoader.load(getClass().getResource("../javafxapplication/Loginjfoenix.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
