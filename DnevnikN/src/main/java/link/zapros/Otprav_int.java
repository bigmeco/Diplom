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

    void OtpLog( String login,String password);
    void OtpReg(Map<String, String> map);
    void OtpGrup(Map<String, String> map);
}
