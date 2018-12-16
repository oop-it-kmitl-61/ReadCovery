package javafxapplication;

import Core.AppAction;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ReadListController implements Initializable {
    @FXML
    private JFXButton backBtn, toProfile, saveListBtn;
    private AppAction app = AppAction.getInstance();
    private HashMap<String, String> readBox;
    public JFXListView history;
    @FXML void changeScene(Stage stage, String newScene){
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(newScene));
            Scene login = new Scene(newRoot);
            stage.setScene(login);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML void ReadInList(){
        try{
            readBox = app.getreadBox();
            String selected = history.getSelectionModel().getSelectedItem().toString();
            Desktop d = Desktop.getDesktop();
            String url = readBox.get(selected);
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
    @FXML void saveList(ActionEvent e){
        changeScene((Stage)saveListBtn.getScene().getWindow(), "SaveList.fxml");
    }
    @FXML void toProfile(ActionEvent e){
        changeScene((Stage)toProfile.getScene().getWindow(), "Profile.fxml");
    }
    @FXML void toMain(ActionEvent e){
        changeScene((Stage)backBtn.getScene().getWindow(), "MainPage.fxml");
    }
    public void initialize(URL location, ResourceBundle resources) {
        readBox = app.getreadBox();
        System.out.println(readBox);
        for ( String key : readBox.keySet() ) {
            int check = 0;
            for(int i=0;i<history.getItems().size();i++){
                if(key.equals(history.getItems().get(i))){
                    check = 1;
                }
            }
            if(check == 0){
                history.getItems().add(key);
            }
        }
    }
}
