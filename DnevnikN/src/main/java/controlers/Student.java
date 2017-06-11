package controlers;

import POJO.*;
import com.jfoenix.transitions.JFXFillTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import link.otvet.OtvJgrups;
import link.otvet.OtvJlog;
import link.otvet.OtvJocenk;
import link.otvet.OtvJpredmet;
import link.zapros.Otpravka;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by bigme on 12.06.2017.
 */
public class Student {

    private JFXFillTransition transition, transition2;
    private static Jlogin jlogin;
    private static List<Groups> groups;
    private static List<Predmeti> predmetis;
    private ObservableList<String> PredmetiData = FXCollections.observableArrayList();
    private ObservableList<Ocenka> OcenkiData = FXCollections.observableArrayList();
    @FXML
    private TableView<Ocenka> TableOcen;
    @FXML
    private TableColumn<Ocenka, String> TbData;
    @FXML
    private TableColumn<Ocenka, String> TbOsenk;
    @FXML
    private ListView<String> ListPR;
    private String idP = "";
    private Otpravka otpravka = new Otpravka();

    @FXML
    public void initialize() {
        otpravka.OtpGroups();
        otpravka.OtpPredmet();
        OtvJgrups otvJgrups = new OtvJgrups();
        groups = otvJgrups.getGroups();
        OtvJpredmet otvJpredmet = new OtvJpredmet();
        predmetis = otvJpredmet.getPredmetis();
        OtvJlog otvJlog = new OtvJlog();
        jlogin = otvJlog.getJlogin();
        TbData.setCellValueFactory(new PropertyValueFactory<>("date"));
        TbOsenk.setCellValueFactory(new PropertyValueFactory<>("ocenka"));
        String[] f = new String[0];
        for (Groups group : groups) {
            if (Objects.equals(jlogin.getInfo().getGruppa(), group.getGruppa())) {
                f = group.getPredmeti().trim().split(",");
            }
        }
        for (String aF : f) {
            for (POJO.Predmeti predmeti : predmetis) {
                if (Objects.equals(aF, predmeti.getId())) {
                    PredmetiData.add(predmeti.getPredmet());
                }
            }
        }
        ListPR.setItems(PredmetiData);
        ListPR.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> observableP, String oldValueP, String newValueP) -> {
                    ObnvTB(newValueP);
                    TableOcen.setItems(OcenkiData);
                });

    }

    public void spravka(ActionEvent actionEvent) throws IOException {
        Stage Prepods = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/FXML/spravka.fxml"));
        Prepods.setMinHeight(240);
        Prepods.setMinWidth(500);
        Prepods.setScene(new Scene(root, 490, 240));
        Prepods.setResizable(false);
        Prepods.show();
        transition = new JFXFillTransition(Duration.millis(5000), root, Color.WHITE, Color.valueOf("80CBC4"));
        transition2 = new JFXFillTransition(Duration.millis(5000), root, Color.valueOf("80CBC4"), Color.WHITE);
        transition.setOnFinished(event -> transition2.play());
        transition2.setOnFinished(event -> transition.play());
        transition.play();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void ObnvTB(String newValueP) {
        TableOcen.getItems().clear();
        for (POJO.Predmeti predmeti : predmetis) {
            if (Objects.equals(newValueP, predmeti.getPredmet())) {
                idP = predmeti.getId();
            }
        }
        otpravka.OtpOcenki(idP, jlogin.getInfo().getId());
        OtvJocenk otvJocenk = new OtvJocenk();
        List<Ocenka> ocenkas = otvJocenk.getOcenka();
        OcenkiData.addAll(ocenkas);
    }
}
