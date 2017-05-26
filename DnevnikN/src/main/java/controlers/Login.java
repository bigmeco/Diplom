package controlers;

import POJO.Jlogin;
import POJO.Jregistr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import link.otvet.OtvJlog;
import link.otvet.OtvJreg;
import link.zapros.Otpravka;
import modul.Errors;

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
    private static Jlogin jlogin;
    private static Jregistr jregistr;

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Go(ActionEvent actionEvent) {
        Otpravka otpravka = new Otpravka();
        otpravka.OtpLog(login.getText(), pasword.getText());
        OtvJlog otvJlog = new OtvJlog();
        jlogin = otvJlog.proverka();
    }

    public void bec(ActionEvent actionEvent)throws Exception {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void Dalie(ActionEvent actionEvent) {
        HashMap mapjs = new HashMap();
        mapjs.put("token", jlogin.getToken());
        mapjs.put("login", logr.getText());
        mapjs.put("password", parr.getText());
        mapjs.put("name", im.getText());
        mapjs.put("lastname", fm.getText());
        mapjs.put("midlename", ot.getText());
        mapjs.put("type", "1");
        Otpravka otpravka = new Otpravka();
        otpravka.OtpReg(mapjs);
        OtvJreg otvJreg = new OtvJreg();
        jregistr = otvJreg.getJreg();
        if (jregistr.getStatus() == 0) {
            Errors.regError(jregistr.getInfo().getText());
        } else {
            if (!Objects.equals(cozdat.getText(), "Заполнить")) {
                im.setDisable(true);
                fm.setDisable(true);
                ot.setDisable(true);
                logr.setDisable(true);
                parr.setDisable(true);
                vizobil7.setDisable(true);
                vizobil6.setDisable(true);
                vizobil5.setDisable(true);
                vizobil4.setDisable(true);
                vizobil3.setDisable(true);
                vizobil.setDisable(false);
                vizobil1.setDisable(false);
                gryp.setDisable(false);
                predmet.setDisable(false);
                plus.setDisable(false);
                cozdat.setText("Заполнить");
            }
        }
        System.out.println(jregistr.getInfo().getText());
    }

    public void Plus(ActionEvent actionEvent) {
        System.out.println(gryp.getText());
        gryp.setText("");
        predmet.setText("");
    }
}
