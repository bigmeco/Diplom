package link.zapros;

import POJO.Jgrup;
import POJO.Jlogin;
import POJO.Jregistr;
import io.reactivex.Observable;

import java.util.Map;

import static link.zapros.realZapros.getRetrofit;

/**
 * Created by bigme on 25.05.2017.
 */
public interface Otprav_int {

    Jlogin OtpLog( String login,String password);
    Jregistr OtpReg(Map<String, String> map);
    Jgrup OtpGrup(Map<String, String> map);
}
