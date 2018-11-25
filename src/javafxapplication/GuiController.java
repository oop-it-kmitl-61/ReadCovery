package javafxapplication;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class GuiController{
    private int index = 0;
    @FXML private JFXButton registBtn, backBtn, toRegister, toProfile, loginBtn;
    @FXML private JFXButton readListBtn, saveListBtn, saveBtn;
    @FXML private ImageView content;

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
        HashMap<Integer, String> data = getData();
        String url = data.get(this.index);
        try {
            d.browse(new URI(url));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

    }

    @FXML void next(ActionEvent e){
        this.index++;
        this.index %= 5;
        String img = getImage(this.index);
        changeImg(img);
    }
    @FXML void previous(ActionEvent e) {
        this.index--;
        if (this.index < 0) {
            this.index += 5;
        }
        String img = getImage(this.index);
        changeImg(img);
    }

    HashMap<Integer, String> getData(){
        HashMap<Integer, String> data = new HashMap<>();
        data.put(0, "https://hilight.kapook.com/view/180689");
        data.put(1, "https://www.catdumb.com/the-cat-lion-king-700/");
        data.put(2, "https://www.catdumb.com/trappist-1-knowledge/");
        data.put(3, "https://www.catdumb.com/game-tee-pom-119/");
        data.put(4, "https://www.catdumb.com/4-cameras-119/");
        return data;
    }
    String getImage(int index){
        HashMap<Integer, String> img = new HashMap<>();
        img.put(0, "image/firstpage/Tae.jpg");
        img.put(1, "image/firstpage/Cat.jpg");
        img.put(2, "image/firstpage/Star.jpg");
        img.put(3, "image/firstpage/Rov.jpg");
        img.put(4, "image/firstpage/Samsung.png");
        return img.get(index);
    }
    @FXML void changeImg(String img){
        Image test = new Image(getClass().getResource(img).toExternalForm());
        content.setImage(test);
    }

    @FXML void save(){

    }
}
