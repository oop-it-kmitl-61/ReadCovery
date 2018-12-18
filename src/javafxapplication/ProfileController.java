package javafxapplication;

import Core.ApiUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML private JFXTextField nameTf;
    @FXML public JFXButton backBtn, logoutBtn, settingBtn;
    @FXML private JFXCheckBox random, political, sport, entertainment, technology;
    @FXML void changeScene(Stage stage, String newScene){
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(newScene));
            Scene login = new Scene(newRoot);
            stage.setScene(login);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML void toMain(ActionEvent e){
        changeScene((Stage)backBtn.getScene().getWindow(), "MainPage.fxml");
    }
    @FXML void logout(){
        changeScene((Stage)logoutBtn.getScene().getWindow(), "Loginjfoenix.fxml");
    }
    private static String catAppend(String catString,String addCat ){
        if(catString.equals("")){
            catString = addCat;
        } else{
            catString += ","+addCat;
        }
        return catString;
    }
    @FXML void setting(){
        System.out.println("Name : "+nameTf.getText());
        String cat="";

        if(random.isSelected()){
            cat = catAppend(cat, "Random");
        }
        if(political.isSelected()){
            cat =catAppend(cat, "political");

        }
        if(sport.isSelected()){
            cat = catAppend(cat, "sport");
        }
        if(entertainment.isSelected()){
            cat = catAppend(cat, "entertainment");
        }
        if(technology.isSelected()){
            cat = catAppend(cat, "technology");
        }

        try {
            System.out.println(ApiUtil.updateCat(cat));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name="";
        try{

            JSONObject jo = ApiUtil.callJson("http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/?token="+ApiUtil.getToken());
            name = jo.getString("name");
        }catch (Exception e){e.printStackTrace();}
        try {
            String[] cats = ApiUtil.getUserCat().split(",");
            for(String cat: cats){
                System.out.println(cat);
                if(cat.equalsIgnoreCase("Random")) random.setSelected(true);
                if(cat.equalsIgnoreCase("Political")) political.setSelected(true);
                if(cat.equalsIgnoreCase("Sport")) sport.setSelected(true);
                if(cat.equalsIgnoreCase("Entertainment")) entertainment.setSelected(true);
                if(cat.equalsIgnoreCase("Technology")) technology.setSelected(true);
            }
            nameTf.setText(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
