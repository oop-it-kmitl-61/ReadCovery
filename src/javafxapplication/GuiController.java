package javafxapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class GuiController  {
    private static HashMap<String, String> saveBox = new HashMap<>();
    private AppAction app = AppAction.getInstance();
    private boolean prev = true;
    private HashMap<String, String> nowData;
    @FXML private JFXButton registBtn, backBtn, toRegister, toProfile, loginBtn, logoutBtn;
    @FXML private JFXButton readListBtn, saveListBtn;
    @FXML private JFXTextField userTf,regEmailTf,regUserTf;
    @FXML private JFXPasswordField passwordTf,regPassPf,regCpTf;
    @FXML private ImageView content;
    @FXML private JFXListView storage;
    @FXML private Label Header;

    @FXML void registerHandler(ActionEvent event){
        System.out.println("Email:" +regEmailTf.getText());
        System.out.println("User:"+regUserTf.getText());
        System.out.println("Pass:"+regPassPf.getText());
        System.out.println("Confirm-Pass:"+regCpTf.getText());
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
        System.out.println(userTf.getText());
        System.out.println(passwordTf.getText());
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
        String title = nowData.get("title");
        String url = nowData.get("url");
        saveBox.put(title, url);
        System.out.println(saveBox);
    }
    @FXML void ReadInList(){
        for ( String key : saveBox.keySet() ) {
            int check = 0;
            for(int i=0;i<storage.getItems().size();i++){
                if(key.equals(storage.getItems().get(i))){
                    check = 1;
                }
            }
            if(check == 0){
                storage.getItems().add(key);
            }
        }
        try{
            String selected = storage.getSelectionModel().getSelectedItem().toString();
            Desktop d = Desktop.getDesktop();
            String url = saveBox.get(selected);
            try {
                d.browse(new URI(url));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }catch(Exception e){
            return ;
        }
    }
    @FXML void logout(){
        changeScene((Stage)logoutBtn.getScene().getWindow(), "Loginjfoenix.fxml");
    }
}
