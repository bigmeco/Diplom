package link.zapros;

import java.util.Map;

/**
 * Created by bigme on 25.05.2017.
 */
public interface Otprav_int {

    void OtpLog( String login,String password);
    void OtpReg(Map<String, String> map);
    void OtpGrup(Map<String, String> map);
}
