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

public class ProfileController implements Initializable {
    @FXML private JFXTextField usTf, emlTf;
    @FXML private JFXPasswordField pswTf;
    @FXML public JFXButton backBtn, logoutBtn, settingBtn;
    @FXML void changeScene(Stage stage, String newScene){
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(newScene));
            Scene login = new Scene(newRoot);
            stage.setScene(login);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML void toMain(ActionEvent e){
        changeScene((Stage)backBtn.getScene().getWindow(), "MainPage.fxml");
    }
    @FXML void logout(){
        changeScene((Stage)logoutBtn.getScene().getWindow(), "Loginjfoenix.fxml");
    }
    @FXML void setting(){
        System.out.println(emlTf.getText());
        System.out.println(usTf.getText());
        System.out.println(pswTf.getText());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emlTf.setText("OOP6969@it.kmitl.ac.th");
        usTf.setText("OOP");
        pswTf.setText("6969");
    }
}
