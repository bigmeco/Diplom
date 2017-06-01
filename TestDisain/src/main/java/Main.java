/**
 * Created by bigme on 22.05.2017.
 */

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.JFXFillTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    JFXFillTransition transition,transition2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXML/loginint.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Diplom");
        primaryStage.setScene(new Scene(root, 300, 180));
        primaryStage.show();

        transition  = new JFXFillTransition(Duration.millis(3000),root,Color.RED,Color.BLUE);
        transition2  = new JFXFillTransition(Duration.millis(3000),root,Color.BLUE,Color.RED);

            transition.setOnFinished(event -> transition2.play());
            transition2.setOnFinished(event -> transition.play());
        transition.play();
    }
}
