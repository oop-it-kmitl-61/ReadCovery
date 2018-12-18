package javafxapplication;

import Core.ApiUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML private JFXButton registBtn, backBtn;
    @FXML private JFXTextField regEmailTf, regNameTf;
    @FXML private JFXPasswordField regPassPf,regCpTf;
    @FXML private Label regErrLb;
    @FXML private JFXCheckBox random, political, sport, entertainment, technology;
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
    @FXML void backHandler(ActionEvent e)  {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        changeScene(stage, "Loginjfoenix.fxml");
    }

    private static String catAppend(String catString,String addCat ){
        if(catString.equals("")){
            catString = addCat;
        } else{
            catString += ","+addCat;
        }
        return catString;
    }
    @FXML void registerHandler(ActionEvent event){
//        System.out.println("Email:" +regEmailTf.getText());
//        System.out.println("User:"+regUserTf.getText());
//        System.out.println("Pass:"+regPassPf.getText());
//        System.out.println("Confirm-Pass:"+regCpTf.getText());
        if(regEmailTf.getText().equals("")){
            errMsg += "Email is empty.\n";
        }
        if(regNameTf.getText().equals("")){
            errMsg += "Name is empty.\n";
        }
        if(regPassPf.getText().equals("") || regCpTf.getText().equals("")){
            errMsg += "Password or Confirm-Password is empty.\n";
        }
        //Password and confirm Password is not equal
        if(!regPassPf.getText().equals(regCpTf.getText())){
            errMsg += "Password and Confirm-Password isn't match.\n";
        }
        //Not select category
        if(!random.isSelected() && !political.isSelected() && !sport.isSelected() && !entertainment.isSelected() && !technology.isSelected()){
            errMsg += "Please Select your favorite category.";
        }
        //if not err
        if(errMsg.equals("")){
            regErrLb.setTextFill(Color.GREEN);
            regErrLb.setText("Register Success!");
            errMsg="";
            String cat = "";

            if (random.isSelected()) {
                cat = catAppend(cat,random.getText());
            }
            if (political.isSelected()) {
//                System.out.print(political.getText() + " ");
                cat = catAppend(cat,political.getText());
            }
            if (sport.isSelected()) {
                cat = catAppend(cat,sport.getText());
            }
            if (entertainment.isSelected()) {
                cat = catAppend(cat,entertainment.getText());

            }
            if (technology.isSelected()) {
                cat = catAppend(cat,technology.getText());
            }
//            System.out.println(cat);
        }else{
            regErrLb.setTextFill(Color.RED);
            regErrLb.setText(errMsg);
            errMsg = "";
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set default value of errMsg don't be null
        errMsg="";

    }
}
