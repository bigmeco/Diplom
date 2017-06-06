package link.zapros;

import POJO.Jgrup;
import POJO.Jlogin;
import POJO.Jregistr;
import POJO.Users;
import io.reactivex.Observable;
import retrofit2.http.*;


import java.util.List;
import java.util.Map;

/**
 * Created by bigi on 05.03.2017.
 */

public interface Retrofit_int {
    @FormUrlEncoded
    @POST("dnevnik/login")
    Observable<Jlogin> getLog(@Field("login") String login, @Field("password") String password);

    //    Call<Jlogin> getLog(@Body Jlogin jlogin);

    @FormUrlEncoded
    @POST("dnevnik/register")
    Observable<Jregistr> getReg(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("dnevnik/addgroup")
    Observable<Jgrup> getGrup(@FieldMap Map<String, String> map);


    @GET("dnevnik/users?type=1")
    Observable<List<Users>> getUser();

    @FormUrlEncoded
    @POST("dnevnik/addpredmet")
    Observable<Jgrup> getPredmet(@Field("token") String token,@Field("prepod") String prepod,@Field("predmet") String predmet);
}

