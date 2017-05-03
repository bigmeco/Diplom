package sample.modol.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import sample.Link.POJO.Jlogin;
import io.reactivex.Observable;
import java.util.Map;

/**
 * Created by bigme on 03.05.2017.
 */
public interface intZapros {
    @FormUrlEncoded
    @POST("dnevnik/login")
    Observable<Jlogin> getLog(@Field("login") String login, @Field("password") String password);


}
