package controlers;

import POJO.*;
import com.jfoenix.controls.JFXButton;
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
import link.otvet.*;
import link.zapros.Otpravka;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by bigme on 07.06.2017.
 */
public class Prepopodovatel {
    private JFXFillTransition transition, transition2;

    public JFXButton DobavOcenk1;
    public JFXButton DobavOcenk2;
    public JFXButton DobavOcenk3;
    public JFXButton DobavOcenk4;
    public JFXButton DobavOcenk5;
    public JFXButton Obnov;
    @FXML
    private ListView<String> Gruppi;
    @FXML
    private ListView<String> Predmeti;
    @FXML
    private ListView<String> studenti;
    private static List<Groups> groups;
    private static List<Users> users;
    private static List<Predmeti> predmetis;
    private static Jlogin jlogin;
    @FXML
    private TableView<Ocenka> TableOcen;

    @FXML
    private TableColumn<Ocenka, String> TbData;

    @FXML
    private TableColumn<Ocenka, String> TbOsenk;
    private Otpravka otpravka = new Otpravka();
    private ObservableList<Ocenka> OcenkiData = FXCollections.observableArrayList();
    private ObservableList<String> gruppData = FXCollections.observableArrayList();
    private ObservableList<String> studentiData = FXCollections.observableArrayList();
    private ObservableList<String> PredmetiData = FXCollections.observableArrayList();
    private String idS = "";
    private String idP = "";

    @FXML
    public void initialize() {
        otpravka.OtpGroups();
        otpravka.OtpPredmet();
        OtvJgrups otvJgrups = new OtvJgrups();
        groups = otvJgrups.getGroups();
        OtvJlog otvJlog = new OtvJlog();
        jlogin = otvJlog.getJlogin();
        OtvJpredmet otvJpredmet = new OtvJpredmet();
        predmetis = otvJpredmet.getPredmetis();
        TbData.setCellValueFactory(new PropertyValueFactory<>("date"));
        TbOsenk.setCellValueFactory(new PropertyValueFactory<>("ocenka"));
        for (Groups group1 : groups) {
            gruppData.add(group1.getGruppa());
        }


        Gruppi.setItems(gruppData);
        Gruppi.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    Predmeti.getItems().clear();
                    studenti.getItems().clear();
                    otpravka.OtpUser("2", newValue);
                    OtvJuser otvJuser = new OtvJuser();
                    users = otvJuser.getUsers();
                    String[] f = new String[0];
                    for (Groups group : groups) {
                        if (Objects.equals(newValue, group.getGruppa())) {
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
                    Predmeti.setItems(PredmetiData);

                    Predmeti.getSelectionModel().selectedItemProperty()
                            .addListener((ObservableValue<? extends String> observableP, String oldValueP, String newValueP) -> {
                                studenti.getItems().clear();
                                for (Users user : users) {
                                    studentiData.add(user.getName() + " " + user.getLastname() + " " + user.getMidlename());
                                }
                                studenti.setItems(studentiData);
                                studenti.getSelectionModel().selectedItemProperty()
                                        .addListener((ObservableValue<? extends String> observableS, String oldValueS, String newValueS) -> {
                                            DobavOcenk1.setDisable(false);
                                            DobavOcenk2.setDisable(false);
                                            DobavOcenk3.setDisable(false);
                                            DobavOcenk4.setDisable(false);
                                            DobavOcenk5.setDisable(false);
                                            ObnvTB(newValueP, newValueS);
                                            Date now = new Date();
                                            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                                            String s = formatter.format(now);
                                            TableOcen.setItems(OcenkiData);
                                            String finalIdS = idS;
                                            String finalIdP = idP;
                                            HashMap mapjs = new HashMap();
                                            mapjs.put("token", jlogin.getToken());
                                            mapjs.put("date", s);
                                            mapjs.put("predmet", finalIdP);
                                            mapjs.put("student", finalIdS);
                                            DobavOcenk1.setOnAction((ActionEvent actionEvent) -> {
                                                mapjs.put("ocenka", "1");
                                                otpravka.OtpAddOcenki(mapjs);
                                                System.out.println("1 oos");
                                            });
                                            DobavOcenk2.setOnAction((ActionEvent actionEvent) -> {
                                                mapjs.put("ocenka", "2");
                                                otpravka.OtpAddOcenki(mapjs);
                                            });
                                            DobavOcenk3.setOnAction((ActionEvent actionEvent) -> {
                                                mapjs.put("ocenka", "3");
                                                otpravka.OtpAddOcenki(mapjs);
                                            });
                                            DobavOcenk4.setOnAction((ActionEvent actionEvent) -> {
                                                mapjs.put("ocenka", "4");
                                                otpravka.OtpAddOcenki(mapjs);
                                            });
                                            DobavOcenk5.setOnAction((ActionEvent actionEvent) -> {
                                                mapjs.put("ocenka", "5");
                                                otpravka.OtpAddOcenki(mapjs);
                                            });
                                            Obnov.setOnAction((ActionEvent actionEvent) ->
                                                    ObnvTB(newValueP, newValueS)
                                            );
                                        });
                            });
                });
    }

    public void exit(ActionEvent actionEvent) throws Exception {
        System.exit(0);
    }


    private void ObnvTB(String newValueP, String newValueS) {
        TableOcen.getItems().clear();
        for (POJO.Predmeti predmeti : predmetis) {
            if (Objects.equals(newValueP, predmeti.getPredmet())) {
                idP = predmeti.getId();
            }
        }
        for (Users user : users) {
            if (Objects.equals(newValueS, user.getName() + " " + user.getLastname() + " " + user.getMidlename())) {
                idS = String.valueOf(user.getId());
            }
        }

        otpravka.OtpOcenki(idP, idS);
        OtvJocenk otvJocenk = new OtvJocenk();
        List<Ocenka> ocenkas = otvJocenk.getOcenka();
        OcenkiData.addAll(ocenkas);
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


}
