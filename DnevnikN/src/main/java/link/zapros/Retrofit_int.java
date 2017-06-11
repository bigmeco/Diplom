package link.zapros;

import POJO.*;
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


    @GET("dnevnik/users?")
    Observable<List<Users>> getUser(@Query("type") String type, @Query("gruppa") String gruppa);

    @FormUrlEncoded
    @POST("dnevnik/addpredmet")
    Observable<Jgrup> getAddPredmet(@Field("token") String token, @Field("prepod") String prepod, @Field("predmet") String predmet);

    @GET("dnevnik/predmeti")
    Observable<List<Predmeti>> getPredmet();

    @GET("dnevnik/groups?")
    Observable<List<Groups>> getGroups();

    @FormUrlEncoded
    @POST("dnevnik/addocenky")
    Observable<Jgrup> getAddOcenki(@FieldMap Map<String, String> map);

    @GET("dnevnik/ocenki")
    Observable<List<Ocenka>> getOcenki(@Query("predmet") String predmet, @Query("student") String student);

}

