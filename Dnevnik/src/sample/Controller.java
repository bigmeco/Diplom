package sample;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import com.sun.deploy.net.URLEncoder;
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
import sample.Link.Seti;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    String zapr = new String();

    public void URL(){
    }



    //  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public void Go(ActionEvent actionEvent) throws IOException {
        String a = login.getText();
        String b = pasword.getText();
        Seti login = new Seti();
        login.Logining(a,b);

        login.ResstrPr(login.Logining(a,b).getToken());
        System.out.println(login.Logining(a,b).getToken());


        try{
            if(login.Logining(a,b).getStatus()==1){
                System.out.println(login.Logining(a,b).getType());
                if(login.Logining(a,b).getType()==0){
                    admin();
                } else if (login.Logining(a,b).getType()==1){
                    Prepod();
                } else if (login.Logining(a,b).getType()==2) {
                    Stydent();
                }
            }
           // System.out.println(loginC.getStatus());
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
              //  Error.error();
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
    public void bec (ActionEvent actionEvent) throws Exception {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
        //Prepods.close();
    }
    public void Dalie(ActionEvent actionEvent) throws UnsupportedEncodingException {
    if ( cozdat.getText()!="Заполнить"){
        String SILK = "https://dnevnik.gamekillers.ru/dnevnik/new_prepod/" +URLEncoder.encode(im.getText(), "UTF-8")+"/"+URLEncoder.encode(fm.getText(),
                        "UTF-8")+"/"+URLEncoder.encode(ot.getText(), "UTF-8")+"/"+logr.getText()+"/"+parr.getText();
     //  URL();

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



    public void Plus(ActionEvent actionEvent) {

    }
}
