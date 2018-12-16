package javafxapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private JFXButton loginBtn, toRegister;
    @FXML private JFXTextField userTf;
    @FXML private JFXPasswordField passwordTf;

    @FXML void changeScene(Stage stage, String newScene){
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(newScene));
            Scene login = new Scene(newRoot);
            stage.setScene(login);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML void login(ActionEvent e){
        System.out.println(userTf.getText());
        System.out.println(passwordTf.getText());
        changeScene((Stage)loginBtn.getScene().getWindow(), "MainPage.fxml");
    }

    @FXML void toRegisterHandle(ActionEvent e){
        changeScene((Stage) toRegister.getScene().getWindow(), "Register.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
