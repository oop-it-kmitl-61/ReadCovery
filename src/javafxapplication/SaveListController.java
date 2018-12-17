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

public class SaveListController implements Initializable {
    @FXML private JFXButton backBtn, toProfile, readListBtn;
    private AppAction app = AppAction.getInstance();
    private HashMap<String, String> saveBox;
    public JFXListView storage;
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
            saveBox = app.getsaveBox();
            String selected = storage.getSelectionModel().getSelectedItem().toString();
            Desktop d = Desktop.getDesktop();
            String url = saveBox.get(selected);
            app.read(selected, url);
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
    @FXML void readList(ActionEvent e){
        changeScene((Stage)readListBtn.getScene().getWindow(), "ReadList.fxml");
    }
    @FXML void toProfile(ActionEvent e){
        changeScene((Stage)toProfile.getScene().getWindow(), "Profile.fxml");
    }
    @FXML void toMain(ActionEvent e){
        changeScene((Stage)backBtn.getScene().getWindow(), "MainPage.fxml");
    }
    @FXML void delete(){
        try{
            saveBox = app.getsaveBox();
            String selected = storage.getSelectionModel().getSelectedItem().toString();
            storage.getItems().remove(selected);
            saveBox.remove(selected);
        }catch(Exception e){
            return ;
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        saveBox = app.getsaveBox();
        System.out.println(saveBox);
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
    }
}
