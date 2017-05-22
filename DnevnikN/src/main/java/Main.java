/**
 * Created by bigme on 22.05.2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXML/loginint.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Журнал");
        primaryStage.setScene(new Scene(root, 300, 180));
        primaryStage.show();
    }
}
