package link.otvet;

import POJO.Jlogin;
import link.zapros.Otprav_int;
import link.zapros.Otpravka;

/**
 * Created by bigme on 25.05.2017.
 */
public class OtvLog {

    public int OtvLog(String a,String b){
        Otprav_int log = new Otpravka();
        Jlogin f = log.OtpLog(a,b);
        int g = f.getStatus();
    return g;
    }
}
