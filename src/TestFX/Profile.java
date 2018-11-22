package TestFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Profile extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Profile");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setAlignment(Pos.CENTER);

        Text text = new Text("Profile");
        text.setFont(Font.font("Tohoma", FontWeight.NORMAL, 20));
        Label email = new Label("E-mail address:");
        Label user = new Label("User name:");
        Label psw = new Label("Password:");
        Label fav = new Label("Favorite list:");
        RadioButton sport = new RadioButton("Sport");
        RadioButton politics = new RadioButton("Politics");
        RadioButton general = new RadioButton("General");
        RadioButton tech = new RadioButton("Technology");
        RadioButton entertain = new RadioButton("Entertainment");
        TextField emailField = new TextField("1150@kmitl.ac.th");
        TextField userField = new TextField("Agape");
        TextField passworField = new TextField("*******");
        userField.setEditable(false);
        emailField.setEditable(false);
        passworField.setEditable(false);
        Button edit = new Button("Edit profile");
        TextFlow back = new TextFlow(new Hyperlink("back"));

        grid.add(text, 0, 0);
        grid.add(user, 0, 1);
        grid.add(userField, 1, 1);
        grid.add(email, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(psw, 0, 3);
        grid.add(passworField, 1, 3);

        grid.add(fav, 0, 4);
        grid.add(general, 1, 4);
        grid.add(sport, 1, 5);
        grid.add(tech, 1, 6);
        grid.add(politics, 1, 7);
        grid.add(entertain, 1, 8);
        grid.add(edit, 0, 10);
        grid.add(back, 2, 10);
        Scene scene = new Scene(grid, 500, 600);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
