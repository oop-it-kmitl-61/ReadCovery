package javafxapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Core.AppAction;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class GuiController{
    HashMap<String, Integer> saveBox = new HashMap<>();
    private AppAction app = AppAction.getInstance();
    private boolean prev = true;
    private HashMap<String, String> nowData;
    @FXML private JFXButton registBtn, backBtn, toRegister, toProfile, loginBtn;
    @FXML private JFXButton readListBtn, saveListBtn;
    @FXML private ImageView content;
    @FXML private JFXListView storage;
    @FXML private Label Header;

    @FXML void registerHandler(ActionEvent event){
        registBtn.setText("wow");
    }

    @FXML void changeScene(Stage stage, String newScene){
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(newScene));
            Scene login = new Scene(newRoot);
            stage.setScene(login);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML void backHandler(ActionEvent e)  {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        changeScene(stage, "Loginjfoenix.fxml");
    }
    @FXML void toRegisterHandle(ActionEvent e){
        changeScene((Stage) toRegister.getScene().getWindow(), "Register.fxml");
    }
    @FXML void toProfile(ActionEvent e){
        changeScene((Stage)toProfile.getScene().getWindow(), "Profile.fxml");
    }
    @FXML void toMain(ActionEvent e){
        changeScene((Stage)backBtn.getScene().getWindow(), "Firstpage.fxml");
    }
    @FXML void login(ActionEvent e){
        changeScene((Stage)loginBtn.getScene().getWindow(), "Firstpage.fxml");
    }
    @FXML void readList(ActionEvent e){
        changeScene((Stage)readListBtn.getScene().getWindow(), "ReadList.fxml");
    }
    @FXML void saveList(ActionEvent e){
        changeScene((Stage)saveListBtn.getScene().getWindow(), "SaveList.fxml");
    }
    @FXML void openLink(ActionEvent e){
        Desktop d = Desktop.getDesktop();
        nowData = app.getCurrent();
        String url = nowData.get("url");
        try {
            d.browse(new URI(url));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

    }

    @FXML void next(ActionEvent e){
        prev = true;
        app.next();
        nowData = app.getCurrent();
        try{
            System.out.println(nowData.get("urlToImage"));
            changeImg(nowData.get("urlToImage"));
            changeHeader(nowData.get("title"));
            System.out.println("Next");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML void previous(ActionEvent e) {
        if(app.previous() && prev) {
            prev = false;
            nowData = app.getCurrent();
            System.out.println(nowData.get("urlToImage"));
            changeImg(nowData.get("urlToImage"));
            changeHeader(nowData.get("title"));
            System.out.println("Previous");
        }
    }

    @FXML void changeImg(String img){
        Image test = new Image(img);
        System.out.println(img);
        content.setImage(test);
    }

    @FXML void changeHeader(String text){
        Header.setText(text);
    }
    @FXML void save(){
        nowData = app.getCurrent();
        ObservableList<String> temp = storage.getItems();
        temp.add(nowData.get("Title"));
        storage.setItems(temp);
        System.out.println(storage);
    }
}
