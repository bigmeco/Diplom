package link.zapros;

import POJO.Jgrup;
import POJO.Jlogin;
import POJO.Jregistr;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import link.zapros.Retrofit_int;
import link.zapros.realZapros;

import java.util.Map;

import static link.zapros.realZapros.getRetrofit;

/**
 * Created by bigme on 25.05.2017.
 */
public class Otpravka implements Otprav_int {
    Retrofit_int call = new realZapros(getRetrofit());


    @Override
    public Jlogin OtpLog(String login,String password) {
        Jlogin jlogin =
        call.getLog("admin","password")
                .observeOn(Schedulers.io())
                .subscribe(s-> new Jlogin() );
       // System.out.println(jlogin[0].getInfo().getLastname());
        return jlogin;
    }

    @Override
    public Jregistr OtpReg(Map<String, String> map) {
        return null;
    }

    @Override
    public Jgrup OtpGrup(Map<String, String> map) {
        return null;
    }
}
