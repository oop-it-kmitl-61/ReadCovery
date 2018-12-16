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
import javafx.scene.control.Label;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML private JFXButton registBtn, backBtn;
    @FXML private JFXTextField regEmailTf,regUserTf;
    @FXML private JFXPasswordField regPassPf,regCpTf;
    @FXML private Label regErrLb;


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
    @FXML void registerHandler(ActionEvent event){
        System.out.println("Email:" +regEmailTf.getText());
        System.out.println("User:"+regUserTf.getText());
        System.out.println("Pass:"+regPassPf.getText());
        System.out.println("Confirm-Pass:"+regCpTf.getText());
        if(regEmailTf.getText().equals("")){
            regErrLb.setText("Error!");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
