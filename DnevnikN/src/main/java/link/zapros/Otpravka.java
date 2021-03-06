package link.zapros;

import link.otvet.*;

import java.util.Map;

import static link.zapros.Retrofit_real.getRetrofit;

/**
 * Created by bigme on 25.05.2017.
 */
public class Otpravka implements Otprav_int {
    Retrofit_int call = new Retrofit_real(getRetrofit());

    @Override
    public void OtpLog(String login, String password) {
        // call.getLog("admin", "password")
        //call.getLog("bigi", "1q2w3e4r")
        call.getLog("bigmen", "06111996")
                //call.getLog(login, password)
                .subscribe(s -> OtvJlog.setJlog(s));
    }


    @Override
    public void OtpReg(Map<String, String> map) {
        call.getReg(map)
                .subscribe(s -> OtvJreg.setJreg(s));
    }

    @Override
    public void OtpGrup(Map<String, String> map) {
        call.getGrup(map)
                .subscribe(s -> OtvJgrup.setJgrup(s));
    }

    @Override
    public void OtpUser(String type, String gruppa) {
        call.getUser(type, gruppa)
                .subscribe(s -> OtvJuser.setUsers(s));
    }

    @Override
    public void OtpAddPredmet(String token, String prepod, String predmet) {
        call.getAddPredmet(token, prepod, predmet)
                .subscribe(s -> OtvJgrup.setJgrup(s));
    }

    @Override
    public void OtpPredmet() {
        call.getPredmet()
                .subscribe(s -> OtvJpredmet.setPredmetis(s));
    }

    @Override
    public void OtpGroups() {
        call.getGroups()
                .subscribe(s -> OtvJgrups.setGroups(s));
    }

    @Override
    public void OtpAddOcenki(Map<String, String> map) {
        call.getAddOcenki(map)
                .subscribe(s -> OtvJgrup.setJgrup(s));
    }

    @Override
    public void OtpOcenki(String predmet, String student) {
        call.getOcenki(predmet, student)
                .subscribe(s -> OtvJocenk.setOcenka(s));
    }


}
