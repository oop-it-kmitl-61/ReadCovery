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
    @FXML private JFXButton registBtn, backBtn,toRegister;
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

}
