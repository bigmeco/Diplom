package link.otvet;

import POJO.Ocenka;

import java.util.List;

/**
 * Created by bigme on 10.06.2017.
 */
public class OtvJocenk {
    public List<Ocenka> getOcenka() {
        return ocenka;
    }

    public static void setOcenka(List<Ocenka> ocenka) {
        OtvJocenk.ocenka = ocenka;
    }

    private static List<Ocenka> ocenka;
}
