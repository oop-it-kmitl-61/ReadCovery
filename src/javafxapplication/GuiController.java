package javafxapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Core.AppAction;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class GuiController{
    HashMap<Integer, String> data = getData();
    HashMap<String, Integer> saveBox = new HashMap<>();
    private AppAction app = AppAction.getInstance();
    private int size = data.size();
    private int index = 0;
    private boolean prev = true;
    private HashMap<String, String> nowData;
    @FXML private JFXButton registBtn, backBtn, toRegister, toProfile, loginBtn;
    @FXML private JFXButton readListBtn, saveListBtn;
    @FXML private ImageView content;
    @FXML private JFXListView storage;
    @FXML private Label Header;

    @FXML void registerHandler(ActionEvent event){
        registBtn.setText("wow");
    }

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
    @FXML void toRegisterHandle(ActionEvent e){
        changeScene((Stage) toRegister.getScene().getWindow(), "Register.fxml");
    }
    @FXML void toProfile(ActionEvent e){
        changeScene((Stage)toProfile.getScene().getWindow(), "Profile.fxml");
    }
    @FXML void toMain(ActionEvent e){
        changeScene((Stage)backBtn.getScene().getWindow(), "Firstpage.fxml");
    }
    @FXML void login(ActionEvent e){
        changeScene((Stage)loginBtn.getScene().getWindow(), "Firstpage.fxml");
    }
    @FXML void readList(ActionEvent e){
        changeScene((Stage)readListBtn.getScene().getWindow(), "ReadList.fxml");
    }
    @FXML void saveList(ActionEvent e){
        changeScene((Stage)saveListBtn.getScene().getWindow(), "SaveList.fxml");
    }
    @FXML void openLink(ActionEvent e){
        Desktop d = Desktop.getDesktop();
        nowData = app.getCurrent();
        String url = nowData.get("url");
        try {
            d.browse(new URI(url));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

    }

    @FXML void next(ActionEvent e){
//        this.index++;
//        this.index %= size;
//        this.prev = true;
//        String img = getImage(this.index);
//        changeImg(img);
//        changeHeader();
//        System.out.println(app.getNow());
        app.next();
        nowData = app.getCurrent();
        changeImg(nowData.get("urlToImage"));
        changeHeader(nowData.get("title"));
        System.out.println("Next");
    }
    @FXML void previous(ActionEvent e) {
        if(app.previous()) {
            nowData = app.getCurrent();
            System.out.println(nowData.get("urlToImage"));
            changeImg(nowData.get("urlToImage"));
            changeHeader(nowData.get("title"));
            System.out.println("Previos");
        }
//        if (this.prev == true) {
//            this.prev = false;
//            this.index--;
//            if (this.index < 0) {
//                this.index += size;
//            }
//
//            String img = getImage(this.index);
//            changeImg(img);
//            changeHeader();
//        }
//        app.prev();
//        nowData = app.getNow();
////        System.out.println(nowData.get("urlToImage"));
//        changeImg(nowData.get("urlToImage"));
//        changeHeader(nowData.get("title"));
//        System.out.println("Prev");
//        System.out.println(app.getPrev().toString());
    }


    HashMap<Integer, String> getData(){
        HashMap<Integer, String> data = new HashMap<>();
        data.put(0, "https://hilight.kapook.com/view/180689");
        data.put(1, "https://www.catdumb.com/the-cat-lion-king-700/");
        data.put(2, "https://www.catdumb.com/trappist-1-knowledge/");
        data.put(3, "https://www.catdumb.com/game-tee-pom-119/");
        data.put(4, "https://www.catdumb.com/4-cameras-119/");
        data.put(5, "https://www.catdumb.com/10-weird-details-about-astronauts-everyday-lives-in-space-378/");
        return data;
    }

    String getHeader(int index){
        HashMap<Integer, String> header = new HashMap<>();
        header.put(0, "ออกหมายเรียกยูทูบเบอร์ดัง ดัดแปลงปืนยิงพลุ พลาด ยิงใส่หมา เข้าข่ายทารุณสัตว์");
        header.put(1, "อย่างฮา เมื่อทาสแมวพาเจ้าเหมียวถ่ายคลิปเลียนแบบตัวอย่าง Lion King เหมือนสุดๆ");
        header.put(2, "14 เรื่องราวน่ารู้ หลังจากการค้นพบระบบดาวเคราะห์ TRAPPIST-1 ที่ทุกคนควรอ่าน…");
        header.put(3, "8 เกม “ตีป้อม” ที่คนไทยควรหามาเล่นสักครั้งลองไหม ลองไหม เอาป่ะล่ะ!?");
        header.put(4, "Samsung เปิดตัวสมาร์ตโฟนรุ่นใหม่GalaxyA9เครื่องแรกที่มีกล้องถึง 4 ตัว!?");
        header.put(5, "10 เรื่องแปลกเกี่ยวกับการใช้ชีวิตระหว่างปฏิบัติการของนักบินอวกาศที่คุณอาจไม่เคยรู้มาก่อน");
        return header.get(index);
    }
    String getImage(int index){
        HashMap<Integer, String> img = new HashMap<>();
        img.put(0, "image/firstpage/Tae.jpg");
        img.put(1, "image/firstpage/Cat.jpg");
        img.put(2, "image/firstpage/Star.jpg");
        img.put(3, "image/firstpage/Rov.jpg");
        img.put(4, "image/firstpage/Samsung.png");
        img.put(5, "image/firstpage/Space.jpg");
        return img.get(index);
    }
    @FXML void changeImg(String img){
        Image test = new Image(img);
        content.setImage(test);
    }

    @FXML void changeHeader(String text){
        Header.setText(text);
    }
    @FXML void save(){
        String header = getHeader(index);
        saveBox.put(header, index);
        System.out.println(saveBox);
        System.out.println(storage);
        // Put Header to Storage
        ObservableList<String> temp = storage.getItems();
        System.out.println(temp);
        temp.add(header);
        storage.setItems(temp);
        System.out.println(storage);
    }

//    @FXML void save(){
//        String header = getHeader(index);
//        saveBox.put(header, index);
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("SaveList.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        storage = (JFXListView) root.lookup("#storage");
//        if (storage!=null){
//            JFXListView test = new JFXListView();
//            test.getItems().add("eiei");
//            System.out.println(test.getItems());
////            ObservableList<String> temp = storage.getItems();
////            temp.add(header);
//            storage.setItems(test.getItems());
//            System.out.println(storage.getItems());
//        }
//    }
}
