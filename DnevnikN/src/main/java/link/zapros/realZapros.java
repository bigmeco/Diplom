package link.zapros;

import POJO.Example;
import POJO.Jlogin;
import POJO.Jregistr;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Map;

/**
 * Created by bigme on 03.05.2017.
 */
public class realZapros implements Retrofit_int {
    private Retrofit retrofit;
    private static final String URL = "https://dnevnik.gamekillers.ru/";

    public realZapros(Retrofit retrofit) {
        this.retrofit = retrofit;
    }


    @Override
    public Observable<Jlogin> getLog(String login, String password) {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getLog(login, password);
    }

    @Override
    public Observable<Jregistr> getReg(Map<String, String> map) {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getReg(map);
    }

    @Override
    public Observable<Example> getGrup(Map<String, String> map) {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getGrup(map);
    }


    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();
    }
}