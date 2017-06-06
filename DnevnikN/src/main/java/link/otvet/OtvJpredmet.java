package link.otvet;

import POJO.Predmeti;

import java.util.List;

/**
 * Created by bigme on 06.06.2017.
 */
public class OtvJpredmet {
    private static List<Predmeti> predmetis;

    public List<Predmeti> getPredmetis() {
        return predmetis;
    }

    public static void setPredmetis(List<Predmeti> predmetis) {
        OtvJpredmet.predmetis = predmetis;
    }
}
