package rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bigme on 04.05.2017.
 */
public class RetrofitServ {
    private static final String URL = "https://dnevnik.gamekillers.ru/";
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URL)
                .build();
    }
}
