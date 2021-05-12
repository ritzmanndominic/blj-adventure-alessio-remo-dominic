package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
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

    String stylesheet;
    String fxmlFile;

    public Gui(String stylesheet, String fxmlFile) {
        this.stylesheet = stylesheet;
        this.fxmlFile = fxmlFile;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(getFxmlFile()));
        Parent root = loader.load();

        Scene scene = new Scene(root, 760, 680);
        scene.getStylesheets().add(getClass().getResource(getStylesheet()).toExternalForm());

        Controller controller = loader.getController();
        controller.setDefault();

        setStage(primaryStage, "Title", 680, 760, Integer.MAX_VALUE, Integer.MAX_VALUE, scene);
    }

    public void setStage(Stage stage, String stageTitle, int minHeight, int minWidth, int maxHeight,
                         int maxWidth, Scene scene) {
        stage.setTitle(stageTitle);
        stage.setMinWidth(minWidth);
        stage.setMinHeight(minHeight);
        stage.setMaxHeight(maxHeight);
        stage.setMaxWidth(maxWidth);
        stage.setScene(scene);
        stage.show();
    }

    public String getStylesheet() {
        return stylesheet;
    }

    public void setStylesheet(String stylesheet) {
        this.stylesheet = stylesheet;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

    public void setFxmlFile(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

//    public Button createButton(String s) {
//        Button button = new Button(s);
//        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        button.setMinSize(100, 50);
//        BorderPane.setMargin(button, new Insets(10));
//        HBox.setMargin(button, new Insets(10));
//        HBox.setHgrow(button, Priority.ALWAYS);
//        return button;
//    }
}
