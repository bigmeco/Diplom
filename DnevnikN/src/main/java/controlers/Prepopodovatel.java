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
import javafx.scene.Parent;
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
    private static List<Ocenka> ocenkas;
    private static List<Predmeti> predmetis;
    private static Jlogin jlogin;
    @FXML
    private TableView<Ocenka> TableOcen;

    @FXML
    private TableColumn<Ocenka, String> TbData;

    @FXML
    private TableColumn<Ocenka, String> TbOsenk;
    Otpravka otpravka = new Otpravka();
    ObservableList<Ocenka> usersData = FXCollections.observableArrayList();
    ObservableList<String> gruppData = FXCollections.observableArrayList();
    ObservableList<String> studentiData = FXCollections.observableArrayList();
    ObservableList<String> PredmetiData = FXCollections.observableArrayList();
    String idS = "";
    String idP = "";

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
        for (int x = 0; x < groups.size(); x++) {
            gruppData.add(groups.get(x).getGruppa());
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
                    for (int x = 0; x < groups.size(); x++) {
                        if (Objects.equals(newValue, groups.get(x).getGruppa())) {
                            f = groups.get(x).getPredmeti().trim().split(",");
                        }
                    }
                    for (int t = 0; t < f.length; t++) {
                        for (int x = 0; x < predmetis.size(); x++) {
                            if (Objects.equals(f[t], predmetis.get(x).getId())) {
                                PredmetiData.add(predmetis.get(x).getPredmet());
                            }
                        }
                    }
                    Predmeti.setItems(PredmetiData);

                    Predmeti.getSelectionModel().selectedItemProperty()
                            .addListener((ObservableValue<? extends String> observableP, String oldValueP, String newValueP) -> {
                                studenti.getItems().clear();
                                for (int x = 0; x < users.size(); x++) {
                                    studentiData.add(users.get(x).getName() + " " + users.get(x).getLastname() + " " + users.get(x).getMidlename());
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
                                            TableOcen.setItems(usersData);
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
        for (int x = 0; x < predmetis.size(); x++) {
            if (Objects.equals(newValueP, predmetis.get(x).getPredmet())) {
                idP = predmetis.get(x).getId();
            }
        }
        for (int x = 0; x < users.size(); x++) {
            if (Objects.equals(newValueS, users.get(x).getName() + " " + users.get(x).getLastname() + " " + users.get(x).getMidlename())) {
                idS = String.valueOf(users.get(x).getId());
            }
        }

        otpravka.OtpOcenki(idP, idS);
        OtvJocenk otvJocenk = new OtvJocenk();
        ocenkas = otvJocenk.getOcenka();
        for (int x = 0; x < ocenkas.size(); x++) {
            usersData.add(ocenkas.get(x));
        }
    }

    public void spravka(ActionEvent actionEvent) throws IOException {
        Stage Prepods = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/FXML/spravka.fxml"));
        Prepods.setMinHeight(240);
        Prepods.setMinWidth(500);
        Prepods.setScene(new Scene(root, 490, 240));
        Prepods.setResizable(false);
        Prepods.show();
        transition = new JFXFillTransition(Duration.millis(6000), root, Color.WHITE, Color.valueOf("80CBC4"));
        transition2 = new JFXFillTransition(Duration.millis(6000), root, Color.valueOf("80CBC4"), Color.WHITE);
        transition.setOnFinished(event -> transition2.play());
        transition2.setOnFinished(event -> transition.play());
        transition.play();

    }


}
