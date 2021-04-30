package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox hBox = new HBox();
        Group group = new Group();

        Button bottom = createButton("1: ");
        Button bottom1 = createButton("2: ");
        Button bottom2 = createButton("3: ");

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(bottom,bottom1,bottom2);

        Text log = new Text("Log:");
        HBox.setHgrow(log, Priority.ALWAYS);
        VBox vBox = new VBox();
        VBox.setMargin(log, new Insets(10));
        log.setFont(Font.font("Verdana", 25));

        vBox.getChildren().add(log);
        Controller.lines(group);
        Controller.doors(group);
        Controller.roomNames(group);

     //   FileInputStream inputstream = new FileInputStream("C:\\Users\\jan04\\Downloads\\image.jpg");
//        Image image = new Image(inputstream);
//        ImageView imageView = new ImageView(image);
//        imageView.setFitHeight(100.0);
//        imageView.setFitWidth(100.0);
//        Group group1 = new Group(imageView);
        Text text = new Text("test");
        text.setFont(Font.font("Verdana", 25));
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        hBox.setAlignment(Pos.BASELINE_RIGHT);

        hBox.getChildren().addAll(text);

        root.setTop(hBox);
        root.setBottom(hBox1);
        root.setCenter(group);
        root.setLeft(vBox);
//        root.setRight(group1);

        Scene scene1 = new Scene(root, 1000, 700, Color.DODGERBLUE);
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

    public static void main(String[] args) {
        launch(args);
    }
}
