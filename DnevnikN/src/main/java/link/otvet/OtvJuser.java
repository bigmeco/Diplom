package link.otvet;

import POJO.Users;

import java.util.List;

/**
 * Created by bigme on 03.06.2017.
 */
public class OtvJuser {

    private static List<Users> users;

    public List<Users> getUsers() {
        return users;
    }

    public static void setUsers(List<Users> users) {
        OtvJuser.users = users;
    }
}
