package sample.Modul;

import javafx.scene.control.Alert;

/**
 * Created by bigi on 03.03.2017.
 */
public class Error {
    public static void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибочка");
        alert.setHeaderText(null);
        alert.setContentText("Какие-то неполадки, повторите попытку позже");
        alert.showAndWait();

    }

    public static void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");
        alert.setHeaderText(null);
        alert.setContentText("Неправельный логин или пароль");
        alert.showAndWait();

    }

    public static void regError(String S) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");
        alert.setHeaderText(null);
        alert.setContentText(S);
        alert.showAndWait();

    }

}
