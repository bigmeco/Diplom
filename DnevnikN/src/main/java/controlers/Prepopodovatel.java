package controlers;

import POJO.Groups;
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
import link.otvet.OtvJuser;
import link.zapros.Otpravka;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by bigme on 07.06.2017.
 */
public class Prepopodovatel {

    @FXML
    private ListView<String> Gruppi;
    private static List<Groups> groups;

    @FXML
    public void initialize() {
        Otpravka otpravka = new Otpravka();
        otpravka.OtpGroups();
        OtvJgrups otvJgrups = new OtvJgrups();
        groups = otvJgrups.getGroups();
        ObservableList<String> usersData = FXCollections.observableArrayList();
        for (int x = 0; x < groups.size(); x++) {
            usersData.add(groups.get(x).getGruppa());
        }

        Gruppi.setItems(usersData);
        Gruppi.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    for (int x = 0; x < groups.size(); x++) {
                        if (newValue == groups.get(x).getGruppa()) {
                            System.out.println(groups.get(x).getPredmeti());
                        }
                    }
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
