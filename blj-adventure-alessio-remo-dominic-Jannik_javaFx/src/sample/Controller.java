package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class Controller {

public static Group doors(Group root){
    for (int i = 500; i < 701; i += 200) {
        Line doorleft = new Line(i, 120, i, 180);
        doorleft.setStroke(Color.DARKRED);
        doorleft.setStrokeWidth(10);
        root.getChildren().add(doorleft);
    }
    for (int i = 300; i < 701; i += 200) {
        Line doorleft = new Line(i, 220, i, 280);
        doorleft.setStroke(Color.DARKRED);
        doorleft.setStrokeWidth(10);
        root.getChildren().add(doorleft);
    }
    for (int i = 300; i < 701; i += 200) {
        Line doorleft = new Line(i, 320, i, 380);
        doorleft.setStroke(Color.DARKRED);
        doorleft.setStrokeWidth(10);
        root.getChildren().add(doorleft);
    }
    for (int i = 700; i < 701; i += 200) {
        Line doorleft = new Line(i, 420, i, 480);
        doorleft.setStroke(Color.DARKRED);
        doorleft.setStrokeWidth(10);
        root.getChildren().add(doorleft);
    }

    for (int i = 150; i < 800; i += 100) {
        Line door = new Line(i, 300, i += 100, 300);
        door.setStroke(Color.DARKRED);
        door.setStrokeWidth(10);
        root.getChildren().add(door);
    }
    for (int i = 350; i < 800; i += 100) {
        Line door = new Line(i, 200, i += 100, 200);
        door.setStroke(Color.DARKRED);
        door.setStrokeWidth(10);
        root.getChildren().add(door);
    }
    for (int i = 350; i < 800; i += 300) {
        Line door = new Line(i, 400, i += 100, 400);
        door.setStroke(Color.DARKRED);
        door.setStrokeWidth(10);
        root.getChildren().add(door);
    }

    return root;
}

public static Group roomNames(Group root){
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

public static Group lines(Group root){
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


}
