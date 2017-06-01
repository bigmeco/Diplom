package link.otvet;

import POJO.Jlogin;
import com.jfoenix.transitions.JFXFillTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import modul.Errors;

import java.io.IOException;

import static java.lang.System.in;

/**
 * Created by bigme on 25.05.2017.
 */
public class OtvJlog {
    private static Jlogin jloginO;
    JFXFillTransition transition, transition2;

    public static void setJlog(Jlogin jlogin) {
        jloginO = jlogin;
    }

    public Jlogin proverka() {
        if (jloginO.getToken() == null) {
            Errors.warning();
        }
        try {
            if (jloginO.getStatus() == 1) {
                System.out.println(jloginO.getType());
                if (jloginO.getType() == 0) {
                    admin();
                } else if (jloginO.getType() == 1) {
                    Prepod();
                } else if (jloginO.getType() == 2) {
                    Stydent();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Errors.error();
                ex.printStackTrace();
            }
        }
        return jloginO;
    }

    private void Prepod() throws IOException {
        Stage Prepods = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/prepodlog.fxml"));
        Prepods.setMinHeight(600);
        Prepods.setMinWidth(900);
        Prepods.setScene(new Scene(root, 900, 600));
        Prepods.setResizable(false);
        Prepods.show();
    }

    private void admin() throws IOException {
        Stage Prepods = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/FXML/admin.fxml"));
        Prepods.setMinHeight(490);
        Prepods.setMinWidth(590);
        Prepods.setScene(new Scene(root, 590, 490));
        Prepods.setResizable(false);
        Prepods.show();
        transition = new JFXFillTransition(Duration.millis(6000), root, Color.valueOf("E0F2F1"), Color.valueOf("EDE7F6"));
        transition2 = new JFXFillTransition(Duration.millis(6000), root, Color.valueOf("EDE7F6"), Color.valueOf("E0F2F1"));
        transition.setOnFinished(event -> transition2.play());
        transition2.setOnFinished(event -> transition.play());
        transition.play();
    }

    private void Stydent() throws IOException {
        Stage stydents = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/stydentlog.fxml"));
        stydents.setMinHeight(600);
        stydents.setMinWidth(600);
        stydents.setScene(new Scene(root, 600, 600));
        stydents.setResizable(false);
        stydents.show();
    }


}
