package javafxapplication;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiController {
    @FXML private JFXButton registBtn, backBtn, toRegister, toProfile, loginBtn, readListBtn, saveListBtn;
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
        Stage stage = (Stage)backBtn.getScene().getWindow();
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
}
