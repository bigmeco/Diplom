package link.otvet;

import POJO.Jregistr;

/**
 * Created by bigme on 26.05.2017.
 */
public class OtvJreg {
    private static Jregistr jregistrO;

    public static void getJreg(Jregistr jregistr) {
        jregistrO = jregistr;
    }

    public void dalee() {

        if (jregistrO.getStatus() == 0) {
            //Error.regError(jregistr.getInfo().getText());
            System.out.println("eeeerrror");
        }
    }
}
