package TestFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Register extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Register");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text regis  = new Text("Register");
        Text check = new Text();
        regis.setFont(Font.font("Tohoma", FontWeight.NORMAL, 20));

        Label username = new Label("User Name");
        Label password = new Label("Password");
        Label confirm = new Label("Confirm-Password");
        Label email = new Label("E-mail Address");

        TextField userBox = new TextField();
        userBox.setPromptText("At least 5 Characters or Numbers");
        TextField passwordBox = new TextField();
        passwordBox.setPromptText("At least 8 Characters or Numbers");
        TextField confirmBox = new TextField();
        confirmBox.setPromptText("Confirm Password");
        TextField emailBox = new TextField();
        emailBox.setPromptText("ex. Netty@mail.com");
        userBox.setPrefWidth(230);

        Button regisButton = new Button("Register now");
        regisButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(false){
                    check.setFill(Color.FIREBRICK);
                    check.setText("Username has already been taken.");
                }else if(false){
                    check.setFill(Color.FIREBRICK);
                    check.setText("Username is too short.");
                }else if(false){
                    check.setFill(Color.FIREBRICK);
                    check.setText("e-mail address has already been taken.");
                }else if(false){
                    check.setFill(Color.FIREBRICK);
                    check.setText("Invalid e-mail address.");
                }else if(true){
                    check.setFill(Color.FIREBRICK);
                    check.setText("Password and confirmation do not match.");
                }
            }
        });
//        HBox buttonBox = new HBox();
//        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
//        buttonBox.getChildren().add(regisButton);

        grid.add(regis, 0, 0, 2, 1);
        grid.add(email, 0, 1);
        grid.add(emailBox, 1, 1);
        grid.add(username, 0, 2);
        grid.add(userBox, 1, 2);
        grid.add(password, 0, 3);
        grid.add(passwordBox, 1, 3);
        grid.add(confirm, 0, 4);
        grid.add(confirmBox, 1, 4);
        grid.add(regisButton, 1, 5);
        grid.add(check, 1, 6);
//        grid.add(buttonBox, 1, 5);


        Scene scene = new Scene(grid, 500, 600);
        window.setScene(scene);
        window.show();
    }
}
