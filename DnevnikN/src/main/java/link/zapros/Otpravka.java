package link.zapros;

import io.reactivex.schedulers.Schedulers;
import link.otvet.OtvJlog;

import java.util.Map;

import static link.zapros.realZapros.getRetrofit;

/**
 * Created by bigme on 25.05.2017.
 */
public class Otpravka implements Otprav_int {
    Retrofit_int call = new realZapros(getRetrofit());

    @Override
    public void OtpLog(String login, String password) {
        call.getLog("admin", "password")
                .observeOn(Schedulers.io())
                .subscribe(s -> OtvJlog.getJlog(s));
    }

    @Override
    public void OtpReg(Map<String, String> map) {

    }

    @Override
    public void OtpGrup(Map<String, String> map) {

    }
}
