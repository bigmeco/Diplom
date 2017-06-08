package link.zapros;

import POJO.*;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by bigme on 03.05.2017.
 */
public class Retrofit_real implements Retrofit_int {
    private Retrofit retrofit;
    private static final String URL = "https://dnevnik.gamekillers.ru/";

    public Retrofit_real(Retrofit retrofit) {
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
    public Observable<Jgrup> getGrup(Map<String, String> map) {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getGrup(map);
    }

    @Override
    public Observable<List<Users>> getUser() {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getUser();
    }

    @Override
    public Observable<Jgrup> getAddPredmet(String token, String prepod, String predmet) {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getAddPredmet(token,prepod,predmet);
    }

    @Override
    public Observable<List<Predmeti>> getPredmet() {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getPredmet();
    }

    @Override
    public Observable<List<Groups>> getGroups() {
        Retrofit_int service = getRetrofit().create(Retrofit_int.class);
        return service.getGroups();
    }


    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();
    }
}
