package javafxapplication;

import Core.AppAction;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static HashMap<String, String> saveBox;
    private AppAction app = AppAction.getInstance();
    private boolean prev = true;
    private HashMap<String, String> nowData;
    @FXML private JFXButton toProfile;
    @FXML private JFXButton readListBtn, saveListBtn;
    @FXML private ImageView content;
    @FXML private Label Header;

    @FXML void changeScene(Stage stage, String newScene){
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(newScene));
            Scene login = new Scene(newRoot);
            stage.setScene(login);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML void toProfile(ActionEvent e){
        changeScene((Stage)toProfile.getScene().getWindow(), "Profile.fxml");
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
        app.read(nowData.get("title"), url);
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
        javafx.scene.image.Image test = new Image(img);
        System.out.println(img);
        content.setImage(test);
    }

    @FXML void changeHeader(String text){
        Header.setText(text);
    }
    @FXML void save(){
        app.save();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nowData = app.getCurrent();
        changeImg(nowData.get("urlToImage"));
        changeHeader(nowData.get("title"));
    }
}
