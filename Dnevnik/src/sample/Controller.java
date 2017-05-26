package sample;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Link.POJO.Jlogin;
import sample.Link.POJO.Jregistr;
import sample.Link.Seti;
import sample.Modul.Error;
import sample.presenter.relLogin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class Controller {
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

    private static Seti loginS;
    private static Jlogin jlogin;
    private static Jregistr jregistr;
    //private ObservableList<tovar> usersData = FXCollections.observableArrayList();
    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
//        idT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("id"));
//        nameT.setCellValueFactory(new PropertyValueFactory<tovar, String>("name"));
//        maneT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("mane"));
//        kolT.setCellValueFactory(new PropertyValueFactory<tovar, Integer>("Kolijestvo"));
//        initData2();
//        idzakazi.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, Integer>("idzakazi"));
//        idprodovets.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, Integer>("idprodovets"));
//        idtovar.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, Integer>("idtovar"));
//        data.setCellValueFactory(new PropertyValueFactory<ISTORIAZ, String>("data"));
//
//        // заполняем таблицу данными
//        tableUsers.setItems(usersData);
//        TB2.setItems(usersData2);

    }
    private void initData() {
//        usersData.add(new tovar(0006,"тыква",700,21));
//        usersData.add(new tovar(0354,"сгущёнка",76,544));
//        usersData.add(new tovar(8318,"арбуз",150,13));
//        usersData.add(new tovar(6387,"ананас",240,35));
//        usersData.add(new tovar(4863,"сок",120,84));
//        usersData.add(new tovar(4866,"яблоко",56,35));
//        usersData.add(new tovar(0120,"творог",89,12));
//        usersData.add(new tovar(8387,"мясо",320,48));



        //usersData.add(new tovar(res.getInt("id"),res.getString("name"),res.getInt("mane")));
    }

    public void Go(ActionEvent actionEvent) throws IOException {
        String a = login.getText();
        String b = pasword.getText();
        relLogin relLogin= new relLogin();
       // relLogin.retrof();
        relLogin.getLogin("admin","password");
        loginS = new Seti();
        jlogin = loginS.Logining(a, b);
        System.out.println(jlogin.getToken());
        if (jlogin.getToken() == null) {
            Error.warning();
        }
        try {


            if (jlogin.getStatus() == 1) {
                System.out.println(jlogin.getType());
                if (jlogin.getType() == 0) {
                    admin();
                } else if (jlogin.getType() == 1) {
                    Prepod();
                } else if (jlogin.getType() == 2) {
                    Stydent();
                }
            }
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Error.error();
                ex.printStackTrace();
            }
        }
    }


    private void Prepod() throws IOException {
        Stage Prepods = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("fxml/prepodlog.fxml"));
        Prepods.setMinHeight(600);
        Prepods.setMinWidth(900);
        Prepods.setScene(new Scene(root, 900, 600));
        Prepods.setResizable(false);
        Prepods.show();
    }

    private void admin() throws IOException {
        Stage Prepods = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("fxml/DaDmin.fxml"));
        Prepods.setMinHeight(490);
        Prepods.setMinWidth(590);
        Prepods.setScene(new Scene(root, 590, 490));
        Prepods.setResizable(false);
        Prepods.show();

    }

    private void Stydent() throws IOException {
        Stage stydents = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("fxml/stydentlog.fxml"));
        stydents.setMinHeight(600);
        stydents.setMinWidth(600);
        stydents.setScene(new Scene(root, 600, 600));
        stydents.setResizable(false);
        stydents.show();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void bec(ActionEvent actionEvent) throws Exception {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
        //Prepods.close();
    }

    public void Dalie(ActionEvent actionEvent) throws UnsupportedEncodingException {
        Map<String, String> mapjs = new HashMap();
        mapjs.put("token", jlogin.getToken());
        mapjs.put("login", logr.getText());
        mapjs.put("password", parr.getText());
        mapjs.put("name", im.getText());
        mapjs.put("lastname", fm.getText());
        mapjs.put("midlename", ot.getText());
        mapjs.put("type", "1");
        jregistr = loginS.ResstrPr(mapjs);
        if (jregistr.getStatus() == 0) {
            Error.regError(jregistr.getInfo().getText());
        } else {
            if (cozdat.getText() != "Заполнить") {

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

                plus.setOnAction((ActionEvent e) -> {
                    //  String SILK1 = "http://211-142-528.local/ci/dnevnik/login/" +gryp.getText()+"/"+predmet.getText();
                    String SILK1 = "https://dnevnik.gamekillers.ru/dnevnik/prepodi";
                    //    URL();
                    System.out.println(gryp.getText());
                    gryp.setText("");
                    predmet.setText("");

                });
            } else {


                // String SILK = "http://211-142-528.local/ci/dnevnik/login/" +gryp.getText()+"/"+predmet.getText();
                // URL(SILK);

            }
        }
    }


    public void Plus(ActionEvent actionEvent) {

    }
}
