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
        call.getLog("bigi", "1q2w3e4r")
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
    public void OtpUser() {
        call.getUser()
                .subscribe(s -> OtvJuser.setUsers(s));
    }

    @Override
    public void OtpAddPredmet(String token,String prepod,String predmet) {
        call.getAddPredmet(token,prepod,predmet)
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


}
