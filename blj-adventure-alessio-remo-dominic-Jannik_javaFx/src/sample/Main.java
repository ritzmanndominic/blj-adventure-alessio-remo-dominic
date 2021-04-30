package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 600, Color.WHITE);

        Controller.lines(root);
        Controller.doors(root);
        Controller.roomNames(root);
        Button button = new Button("Start Game");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                IO io = new IO();
                Game game = new Game();
                Player player = new Player();
                Player player1 = new Player(player.getItemList(), 3);
                io.switcher(game, player1);
            }
        });

        root.getChildren().add(button);
        primaryStage.setTitle("Adv-Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
