package link.zapros;

import POJO.Example;
import POJO.Jlogin;
import POJO.Jregistr;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


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
    Call<Jregistr> getReg(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("dnevnik/addgroup")
    Call<Example> getGrup(@FieldMap Map<String, String> map);

}

