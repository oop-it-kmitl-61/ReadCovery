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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ForgotPassword extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Forgot password");
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setAlignment(Pos.CENTER);

        Text forgot = new Text("Reset password");
        forgot.setFont(Font.font("Tohoma", FontWeight.NORMAL, 20));
        Label email = new Label("Enter your e-mail address");
        TextField emailField = new TextField();
//        emailField.setPromptText("enter your e-mail address");
        emailField.setPrefWidth(220);
        Button reset = new Button("Reset my password");
        Text check = new Text();
        TextFlow back = new TextFlow(new Hyperlink("Back"));
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(false) {
                    check.setFill(Color.FIREBRICK);
                    check.setText("e-mail address not found.");
                }else{
                    check.setFill(Color.GREEN);
                    check.setText("password has been sent to your email!");
                }
            }
        });

        grid.add(forgot, 0, 0);
        grid.add(email, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(reset, 1, 2);
        grid.add(check, 1, 3);
        grid.add(back, 0, grid.getChildren().size());
        Scene scene = new Scene(grid, 500, 600);
        window.setScene(scene);
        window.show();
    }
}
