package controlers;

import com.jfoenix.transitions.JFXFillTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by bigme on 22.05.2017.
 */
public class Login {

    @FXML
    public Label vizobil1;
    public TextField predmet;
    public TextField gryp;
    public Button cozdat;
    public TextField im;
    public TextField fm;
    public TextField ot;
    public Label vizobil4;
    public Label vizobil5;
    public Label vizobil3;
    public Label vizobil7;
    public Label vizobil6;
    public TextField logr;
    public TextField parr;
    @FXML
    private TextField login;
    @FXML
    private TextField pasword;
    @FXML
    private Label vizobil;
    @FXML
    private Button plus;

    @FXML
    private AnchorPane rootPane;

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Go(ActionEvent actionEvent) {
        JFXFillTransition transition  = new JFXFillTransition();
        transition.setDuration(Duration.millis(5000));
        transition.setRegion(rootPane);
        transition.setFromValue(Color.WHITE);
        transition.setToValue(Color.BLUE);
        transition.play();
    }

    public void bec(ActionEvent actionEvent) throws Exception {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void Dalie(ActionEvent actionEvent) {

    }

    public void Plus(ActionEvent actionEvent) {

    }
}
