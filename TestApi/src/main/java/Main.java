import rest.Jlogin;
import rest.intZapros;
import rest.realZapros;
import retrofit2.Call;
import io.reactivex.Observable;
import retrofit2.Response;

import java.io.IOException;


/**
 * Created by bigme on 04.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Call<Jlogin> call = new realZapros().getLog("admin","password");
        //Call<Jlogin> call = service.getLog(mapjs);
        Response<Jlogin> response = null;
        try {
            response = call.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.body().getInfo().getName());


    }
}
