package controlers;

import POJO.Jlogin;
import POJO.Jregistr;
import POJO.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
 * Created by bigme on 03.06.2017.
 */
public class Admin {

    private static Jlogin jlogin;
    private static Jregistr jregistr;
    @FXML
    public Label vizobil1;
    public TextField predmet;
    public TextField gryp;
    public Button cozdat;
    public Button obnovit;
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
    private Label vizobil;
    @FXML
    private Button plus;
    @FXML
    private TableView<Users> TBusers;

    @FXML
    private TableColumn<Users, Integer> TKid;

    @FXML
    private TableColumn<Users, String> TKname;

    @FXML
    private TableColumn<Users, String> TKlastname;

    @FXML
    private TableColumn<Users, String> TKfestname;
    private static List<Users> users;
    private ObservableList<Users> usersData = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        Otpravka otpravka = new Otpravka();
        otpravka.OtpUser();
        OtvJuser otvJuser = new OtvJuser();
        users = otvJuser.getUsers();
        for (int x = 0;x <users.size();x++){
            usersData.add(users.get(x));}
        TKid.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        TKname.setCellValueFactory(new PropertyValueFactory<Users, String>("name"));
        TKlastname.setCellValueFactory(new PropertyValueFactory<Users, String>("lastname"));
        TKfestname.setCellValueFactory(new PropertyValueFactory<Users, String>("midlename"));
        TBusers.setItems(usersData);
    }

    public void bec(ActionEvent actionEvent) throws Exception {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void Dalie(ActionEvent actionEvent) {
        OtvJlog otvJlog = new OtvJlog();
        jlogin = otvJlog.getJlogin();
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
                cozdat.setDisable(true);

        }
        System.out.println(jregistr.getInfo().getText());
    }

    public void Plus(ActionEvent actionEvent) {
        if (jregistr.getStatus() == 0) {
            Errors.regError(jregistr.getInfo().getText());
        } else {
            HashMap mapjs = new HashMap();
            mapjs.put("token", jlogin.getToken());
            mapjs.put("prepod", jregistr.getInfo().getId());
            mapjs.put("gruppa", gryp.getText());
            mapjs.put("predmeti", predmet.getText());
            Otpravka otpravka = new Otpravka();
            otpravka.OtpGrup(mapjs);
            gryp.setText("");
            predmet.setText("");
        }
    }

    public void ObnovTab(Event event) {


        }

    public void Obnovit(ActionEvent actionEvent) {
        im.setDisable(false);
        im.setText("");
        fm.setDisable(false);
        fm.setText("");
        ot.setDisable(false);
        ot.setText("");
        logr.setDisable(false);
        logr.setText("");
        parr.setDisable(false);
        parr.setText("");
        vizobil7.setDisable(false);
        vizobil6.setDisable(false);
        vizobil5.setDisable(false);
        vizobil4.setDisable(false);
        vizobil3.setDisable(false);
        vizobil.setDisable(true);
        vizobil1.setDisable(true);
        gryp.setDisable(true);
        predmet.setDisable(true);
        plus.setDisable(true);
        cozdat.setDisable(false);
    }
    public void ObnovTb(ActionEvent actionEvent) {
    }
}
