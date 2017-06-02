package link.zapros;

import link.otvet.OtvJgrup;
import link.otvet.OtvJlog;
import link.otvet.OtvJreg;

import java.util.Map;

import static link.zapros.Retrofit_real.getRetrofit;

/**
 * Created by bigme on 25.05.2017.
 */
public class Otpravka implements Otprav_int {
    Retrofit_int call = new Retrofit_real(getRetrofit());

    @Override
    public void OtpLog(String login, String password) {
        call.getLog("admin", "password")
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
}
