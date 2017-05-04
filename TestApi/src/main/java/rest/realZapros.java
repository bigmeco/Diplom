package rest;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by bigme on 03.05.2017.
 */
public class realZapros implements intZapros {
    private Retrofit retrofit;
    private static final String URL = "https://dnevnik.gamekillers.ru/";



    @Override
    public Call<Jlogin> getLog(String login, String password) {
        intZapros service = getRetrofit().create(intZapros.class);
        return service.getLog(login, password);
    }



    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();
    }
}
