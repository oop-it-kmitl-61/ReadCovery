package TestFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ChooseCategory extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("choose directory");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setAlignment(Pos.CENTER);

        Text text = new Text("Choose your favorite");
        text.setFont(Font.font("Tohoma", FontWeight.NORMAL, 20));
        RadioButton sport = new RadioButton("Sport");
        RadioButton politics = new RadioButton("Politics");
        RadioButton general = new RadioButton("General");
        RadioButton tech = new RadioButton("Technology");
        RadioButton entertain = new RadioButton("Entertainment");
        Button submit = new Button("Submit");
        TextFlow back = new TextFlow(new Hyperlink("Back"));

        grid.add(text, 0, 0);
        grid.add(general, 0, 1);
        grid.add(sport, 0, 2);
        grid.add(tech, 0, 3);
        grid.add(politics, 0, 4);
        grid.add(entertain, 0, 5);
        grid.add(submit, 0, 6);
        grid.add(back, 1, 7);

        Scene scene = new Scene(grid, 500, 600);
        window.setScene(scene);
        window.show();
    }
}
