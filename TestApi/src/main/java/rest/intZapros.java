package rest;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



/**
 * Created by bigme on 03.05.2017.
 */
public interface intZapros {
    @FormUrlEncoded
    @POST("dnevnik/login")
    Call<Jlogin> getLog(@Field("login") String login, @Field("password") String password);


}
