package TestFX;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Firstpage extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("First page");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        Button read = new Button("ReadList");
        Button saveList = new Button("SaveList");
        Button profile = new Button("Profile");
        Button previous = new Button("Previous");
        Button save = new Button("Save");
        Button next = new Button("Next");

        Scene scene = new Scene(grid, 500, 600);
        read.setPrefSize(500/3, 10);
        saveList.setPrefSize(500/3, 10);
        profile.setPrefSize(500/3, 10);
        previous.setPrefSize(500/3, 10);
        save.setPrefSize(500/3, 10);
        next.setPrefSize(500/3, 10);


//        String url = "http://placekitten.com/200/300";
//
//        ImageView view = new ImageView();
//        Image img = new Image(url, true);
//        view.setFitWidth(400);
//        view.setFitHeight(400);
//        view.setX(20);
//        view.setImage(img);

//        grid.getChildren().add(view);
        grid.add(read, 0, 0);
        grid.add(saveList, 1, 0);
        grid.add(profile, 2, 0);

//        System.out.println(grid.getChildren().size());
        grid.add(previous, 0, 50);
        grid.add(save, 1, 50);
        grid.add(next, 2, 50);

        window.setScene(scene);
        window.show();
        window.heightProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1,Object arg2) {
                double width = (double) arg2;
                read.setPrefWidth(width);
                saveList.setPrefWidth(width);
                profile.setPrefWidth(width);
                previous.setPrefWidth(width);
                save.setPrefWidth(width);
                next.setPrefWidth(width);
//                view.setFitWidth(width);
//                view.setFitHeight(width);
            }
        });
    }
}
