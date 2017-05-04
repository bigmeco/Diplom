package sample.presenter;

import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Field;
import sample.modol.rest.intZapros;
import sample.modol.rest.realZapros;

/**
 * Created by bigme on 03.05.2017.
 */
public class relLogin implements intLogin {

private intZapros login;


String s;

    public void getLogin(String a, String b){

        login = new realZapros();
        login.getLog(a, b).subscribeOn(Schedulers.io())
                .filter(p->p.getStatus()!= null).map( p -> p.getToken()).subscribe(p-> s=p);
        System.out.println(s);

    }

}
