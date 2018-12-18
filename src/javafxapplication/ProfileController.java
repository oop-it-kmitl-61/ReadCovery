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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML private JFXTextField nameTf;
    @FXML public JFXButton backBtn, logoutBtn, settingBtn;
    @FXML private JFXCheckBox random, political, sport, entertainment, technology;
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
        System.out.println("Name : "+nameTf.getText());
        System.out.print("Favorite : ");
        if(random.isSelected()){
            System.out.print(random.getText()+" ");
        }
        if(political.isSelected()){
            System.out.print(political.getText()+" ");
        }
        if(sport.isSelected()){
            System.out.print(sport.getText()+" ");
        }
        if(entertainment.isSelected()){
            System.out.print(entertainment.getText()+" ");
        }
        if(technology.isSelected()){
            System.out.print(technology.getText()+" ");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name ="";
        try {
            String[] cats = ApiUtil.getUserCat().split(",");
            for(String cat: cats){
                if(cat.equals("Random")) random.setSelected(true);
                if(cat.equals("Political")) political.setSelected(true);
                if(cat.equals("Sport")) sport.setSelected(true);
                if(cat.equals("Entertainment")) entertainment.setSelected(true);
                if(cat.equals("Technology")) technology.setSelected(true);
            }
            nameTf.setText("OOP");
            random.setSelected(true);
            sport.setSelected(true);
            technology.setSelected(true);
        }catch (Exception e){

        }
    }
}
