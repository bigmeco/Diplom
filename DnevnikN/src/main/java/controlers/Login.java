package controlers;

import POJO.Jlogin;
import POJO.Jregistr;
import POJO.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import link.otvet.OtvJlog;
import link.otvet.OtvJreg;
import link.otvet.OtvJuser;
import link.zapros.Otpravka;
import modul.Errors;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by bigme on 22.05.2017.
 */
public class Login {


    @FXML
    private TextField login;
    @FXML
    private TextField pasword;


    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Go(ActionEvent actionEvent) {
        Otpravka otpravka = new Otpravka();
        otpravka.OtpLog(login.getText(), pasword.getText());
        OtvJlog otvJlog = new OtvJlog();
        otvJlog.proverka();


    }



}
