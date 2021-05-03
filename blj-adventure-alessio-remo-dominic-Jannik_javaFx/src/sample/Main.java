package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    Gui gui = new Gui();

    @Override
    public void start(Stage primaryStage) throws Exception {
gui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
