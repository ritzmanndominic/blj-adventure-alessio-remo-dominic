package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {
    IO io = new IO();
    private static Color DOOR_COLOR;
    private ObservableList<String> logContent = FXCollections.observableArrayList();
    @FXML
    private Label labelLocation;

    @FXML
    private Label labelHealth;

    @FXML
    private Button button1;

    @FXML
    private Button button7;

    @FXML
    private Button button6;

    @FXML
    private Button button3;

    @FXML
    private Button button5;

    @FXML
    private Button button4;

    @FXML
    private Button button2;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private ListView<String> logBook;

    @FXML
    private Label labelBalcony;

    @FXML
    private Label labelLivingroom;

    @FXML
    private Label labelBathroom;

    @FXML
    private Label labelGym;

    @FXML
    private Label labelToilet;

    @FXML
    private Label labelStoreroom;

    @FXML
    private Label labelBedroom;

    @FXML
    private Label labelKitchen;

    @FXML
    private Label labelSecretroom;

    @FXML
    private Label labelOffice;

    private Label[] roomNames = {labelOffice, labelKitchen, labelBedroom, labelToilet, labelBalcony, labelStoreroom,
            labelGym, labelLivingroom, labelBathroom, labelSecretroom};

    private Button[] buttons = {getButton1(), button2, button3, button4, button5, button6, button7, button8, button9};

    @FXML
    void button1Pressed(ActionEvent event) {
        getLogContent().add(io.rooms(5, new Game()));
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button2Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button3Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button4Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button5Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button6Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button7Pressed(ActionEvent event) {
        getButton7().setText("Output Playtime");
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button8Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    @FXML
    void button9Pressed(ActionEvent event) {
        getLogContent().add("text");
        getLogBook().setItems(getLogContent());
    }

    public void setDefault() {
        getButton1().setText("possible rooms");
        getButton2().setText("move to room");
        getButton3().setText("inspect room");
        getButton4().setText("show inventory");
        getButton5().setText("save data");
        getButton6().setText("load saved data");
        getButton7().setText("show playtime");
        getButton8().setText("go to previous room");
        getButton9().setText("exit game");
        
    }

    public static Group doors(Group root) {
        ArrayList<Line> doors = new ArrayList<>();

        for (int i = 500; i < 701; i += 200) {
            Line door = new Line(i, 120, i, 180);
            doors.add(door);
        }
        for (int i = 300; i < 701; i += 200) {
            Line door = new Line(i, 220, i, 280);
            doors.add(door);
        }
        for (int i = 300; i < 701; i += 200) {
            Line door = new Line(i, 320, i, 380);
            doors.add(door);
        }
        for (int i = 700; i < 701; i += 200) {
            Line door = new Line(i, 420, i, 480);
            doors.add(door);
        }

        for (int i = 150; i < 800; i += 100) {
            Line door = new Line(i, 300, i += 100, 300);
            doors.add(door);
        }
        for (int i = 350; i < 800; i += 100) {
            Line door = new Line(i, 200, i += 100, 200);
            doors.add(door);
        }
        for (int i = 350; i < 800; i += 300) {
            Line door = new Line(i, 400, i += 100, 400);
            doors.add(door);
        }
        for (Line door : doors) {
            door.setStroke(Color.RED);
            door.setStrokeWidth(10);
            root.getChildren().add(door);
        }
        return root;
    }

    public static Group roomNames(Group root) {
        String[] roomName = new String[]{"", "Bathroom", "Storeroom", "", "Balcony",
                "Livingroom", "Bedroom", "Toilet", "Balcony", "Livingroom", "Bedroom", "Secretroom",
                "Balcony", "Gym", "Kitchen", "Office"};

        int koordinate = 150;
        int roomList = 0;
        for (int x = 0; x < 4; x++) {
            for (int i = 150; i < 500; i += 100) {
                Text t = new Text(koordinate, i, roomName[roomList]);
                t.setFont(new Font(20));
                t.setStroke(Color.TAN);
                root.getChildren().add(t);
                ++roomList;
            }
            koordinate = koordinate + 200;
        }
        return root;
    }

    public static Group lines(Group root) {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 100; i < 600; i += 100) {
            Line lineHorizontal = new Line(100, i, 900, i);
            lineHorizontal.setStroke(Color.BLACK);
            lineHorizontal.setStrokeWidth(2);
            lines.add(lineHorizontal);
        }
        for (int i = 100; i < 1100; i += 200) {
            Line lineWagrecht = new Line(i, 100, i, 500);
            lineWagrecht.setStroke(Color.BLACK);
            lineWagrecht.setStrokeWidth(2);
            lines.add(lineWagrecht);
        }
        root.getChildren().addAll(lines);

        return root;
    }

    public static Color getDoorColor() {
        return DOOR_COLOR;
    }

    public ListView<String> getLogBook() {
        return logBook;
    }

    public void setLogBook(ListView<String> logBook) {
        this.logBook = logBook;
    }

    public ObservableList<String> getLogContent() {
        return logContent;
    }

    public void setLogContent(ObservableList<String> logContent) {
        this.logContent = logContent;
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

    public Button getButton4() {
        return button4;
    }

    public void setButton4(Button button4) {
        this.button4 = button4;
    }

    public Button getButton5() {
        return button5;
    }

    public void setButton5(Button button5) {
        this.button5 = button5;
    }

    public Button getButton6() {
        return button6;
    }

    public void setButton6(Button button6) {
        this.button6 = button6;
    }

    public Button getButton7() {
        return button7;
    }

    public void setButton7(Button button7) {
        this.button7 = button7;
    }

    public Button getButton8() {
        return button8;
    }

    public void setButton8(Button button8) {
        this.button8 = button8;
    }

    public Button getButton9() {
        return button9;
    }

    public void setButton9(Button button9) {
        this.button9 = button9;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public void setButtons(Button[] buttons) {
        this.buttons = buttons;
    }

    public Label[] getRoomNames() {
        return roomNames;
    }

    public void setRoomNames(Label[] roomNames) {
        this.roomNames = roomNames;
    }
}
