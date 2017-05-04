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

    public realZapros(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Observable<Jlogin> getLog(String login, String password) {
        intZapros service = retrofit.create(intZapros.class);
        return service.getLog(login, password);
    }




}
