package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    Gui gui = new Gui();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root, 760, 680);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        Stage stage = new Stage();
        stage.setTitle("Title");
        stage.setMinWidth(760);
        stage.setMinHeight(680);
        stage.setScene(scene);
        stage.show();
//
//        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

