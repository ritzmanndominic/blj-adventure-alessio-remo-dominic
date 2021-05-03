package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.Flow;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        Group group = new Group();

        Button bottom = createButton("1: ");
        Button bottom1 = createButton("2: ");
        Button bottom2 = createButton("3: ");

        hBox1.getChildren().addAll(bottom,bottom1,bottom2);

        Text log = new Text("Log:");
        HBox.setHgrow(log, Priority.ALWAYS);
        VBox vBox = new VBox();
        VBox.setMargin(log, new Insets(10));
        log.setFont(Font.font("Verdana", 25));
        log.setTextAlignment(TextAlignment.CENTER);

        vBox.getChildren().add(log);
        Controller.lines(group);
        Controller.doors(group);
        Controller.roomNames(group);

        root.setRight(hBox);
        root.setBottom(hBox1);
        root.setCenter(group);
        root.setLeft(vBox);

        root.setTop(hBox2);

        Text room = new Text("Room: ");
        HBox.setHgrow(room, Priority.ALWAYS);
        VBox.setMargin(room, new Insets(10));
        room.setFont(Font.font("Verdana", 25));
        vBox.getChildren().add(room);

        Text health = new Text("Health: ");
        HBox.setHgrow(health, Priority.ALWAYS);
        VBox.setMargin(health, new Insets(10));
        health.setFont(Font.font("Verdana", 25));
        vBox.getChildren().add(health);

        hBox2.getChildren().addAll(room, health);
        hBox2.setAlignment(Pos.BASELINE_CENTER);

        Button button2 = new Button("Start Game");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                IO io = new IO();
                Game game = new Game();
                Player player = new Player();
                Player player1 = new Player(player.getItemList(), 3);
                io.switcher(game, player1);
            }
        });

        hBox.getChildren().add(button2);
        hBox.setMargin(button2, new Insets(16));
        button2.setFont(Font.font("Verdana", 15));

        Scene scene1 = new Scene(root, 1100, 700, Color.DODGERBLUE);
        primaryStage.setScene(scene1);
        scene1.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.show();
    }

    public Button createButton(String s) {
        Button button = new Button(s);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setMinSize(100, 50);
        BorderPane.setMargin(button, new Insets(10));
        HBox.setMargin(button, new Insets(10));
        HBox.setHgrow(button, Priority.ALWAYS);
        return button;
    }
}
