package controlers;

import POJO.Groups;
import POJO.Predmeti;
import POJO.Users;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import link.otvet.OtvJgrups;
import link.otvet.OtvJpredmet;
import link.otvet.OtvJuser;
import link.zapros.Otpravka;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by bigme on 07.06.2017.
 */
public class Prepopodovatel {

    @FXML
    private ListView<String> Gruppi;
    @FXML
    private ListView<String> Predmeti;
    @FXML
    private ListView<String> studenti;
    private static List<Groups> groups;
    private static List<Users> users;
    private static List<Predmeti> predmetis;

    @FXML
    public void initialize() {
        Otpravka otpravka = new Otpravka();
        otpravka.OtpGroups();
        otpravka.OtpPredmet();
        OtvJgrups otvJgrups = new OtvJgrups();
        groups = otvJgrups.getGroups();

        OtvJpredmet otvJpredmet = new OtvJpredmet();
        predmetis = otvJpredmet.getPredmetis();
        ObservableList<String> gruppData = FXCollections.observableArrayList();
        ObservableList<String> studentiData = FXCollections.observableArrayList();
        ObservableList<String> PredmetiData = FXCollections.observableArrayList();

        for (int x = 0; x < groups.size(); x++) {
            gruppData.add(groups.get(x).getGruppa());
        }


        Gruppi.setItems(gruppData);
        Gruppi.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    Predmeti.getItems().clear();
                    otpravka.OtpUser("2", "null");
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
                            .addListener((observableP, oldValueP, newValueP) -> {
                                studenti.getItems().clear();

                                for (int x = 0; x < users.size(); x++) {
                                    studentiData.add(users.get(x).getName() + " " + users.get(x).getLastname() + " " + users.get(x).getMidlename());
                                }
                                studenti.setItems(studentiData);
                                studenti.getSelectionModel().selectedItemProperty()
                                        .addListener((observableS, oldValueS, newValueS) -> {


                                        });

                            });
                });

    }

    public void exit(ActionEvent actionEvent) throws Exception {
        System.exit(0);
    }

    public void DobavPred(ActionEvent actionEvent) {


    }


    public void DobavStud(ActionEvent actionEvent) {


    }
}
