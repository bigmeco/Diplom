package link.otvet;

import POJO.Jregistr;

/**
 * Created by bigme on 26.05.2017.
 */
public class OtvJreg {
    private static Jregistr jregistrO;

    public static void setJreg(Jregistr jregistr) {
        jregistrO = jregistr;
    }

    public Jregistr getJreg() {
        return jregistrO;
    }
}