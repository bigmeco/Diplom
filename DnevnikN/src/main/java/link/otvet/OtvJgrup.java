package link.otvet;

import POJO.Jgrup;

/**
 * Created by bigme on 26.05.2017.
 */
public class OtvJgrup {

    private static Jgrup jgrup;

    public static Jgrup getJgrup() {
        return jgrup;
    }

    public static void setJgrup(Jgrup jgrup) {
        OtvJgrup.jgrup = jgrup;
    }
}
