package TestFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class regSuccess extends Application {
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
        grid.setPadding(new Insets(10, 10, 10, 10));

        Text success = new Text("Your account is ready!");
        success.setFont(Font.font("Tohoma", FontWeight.NORMAL, 20));
        success.setFill(Color.GREEN);
        Button sign_in = new Button("Sign in now");
        sign_in.setPrefWidth(170);
        grid.add(success, 1, 0);
        grid.add(sign_in, 1, 2);
        Scene scene = new Scene(grid, 500, 600);
        window.setScene(scene);
        window.show();
    }
}
