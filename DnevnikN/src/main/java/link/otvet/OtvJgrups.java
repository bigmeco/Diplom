package link.otvet;

import POJO.Groups;

import java.util.List;

/**
 * Created by bigme on 08.06.2017.
 */
public class OtvJgrups {
    public List<Groups> getGroups() {
        return groups;
    }

    public static void setGroups(List<Groups> groups) {
        OtvJgrups.groups = groups;
    }

    private static List<Groups> groups;
}
