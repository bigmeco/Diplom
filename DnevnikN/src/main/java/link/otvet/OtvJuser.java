package link.otvet;

import POJO.Users;

/**
 * Created by bigme on 03.06.2017.
 */
public class OtvJuser {

    private static Users users;

    public static Users getUsers() {
        return users;
    }

    public static void setUsers(Users users) {
        OtvJuser.users = users;
    }
}
