package javafxapplication;

import Core.ApiUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private JFXButton loginBtn, toRegister;
    @FXML private JFXTextField emailTf;
    @FXML private Label logErrLb;
    @FXML private JFXPasswordField passwordTf;
    private String errMsg;

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
//        System.out.println(emailTf.getText());
//        System.out.println(passwordTf.getText());
        if(emailTf.getText().equals("")){
            errMsg += "Email is empty\n";
        }
        if(passwordTf.getText().equals("")){
            errMsg += "Password is empty\n";
        }
        try {
            String token = ApiUtil.loginRequest(emailTf.getText(), passwordTf.getText());
            if (token == null) {
                errMsg += "Email or Password are incorrect";
            }else{
                ApiUtil.setToken(token);
                System.out.println(ApiUtil.getToken());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        if(errMsg.equals("")){
            changeScene((Stage) loginBtn.getScene().getWindow(), "MainPage.fxml");
        }
        else {
            logErrLb.setText(errMsg);
            errMsg="";
        }
    }

    @FXML void toRegisterHandle(ActionEvent e){
        changeScene((Stage) toRegister.getScene().getWindow(), "Register.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set errMsg empty when init this page
        errMsg="";
    }
}
