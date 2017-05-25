package controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import link.otvet.OtvLog;
import link.zapros.Otprav_int;
import link.zapros.Otpravka;

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


    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Go(ActionEvent actionEvent) {
        String a = login.getText();
        String b = pasword.getText();
        OtvLog fg = new OtvLog();
        int r = fg.OtvLog(a,b);


    }
}
