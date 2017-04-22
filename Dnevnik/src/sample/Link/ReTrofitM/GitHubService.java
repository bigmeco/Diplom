package sample.Link.ReTrofitM;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import sample.Link.POJO.Jlogin;
import sample.Link.POJO.Jregistr;

import java.util.Map;

/**
 * Created by bigi on 05.03.2017.
 */

public interface GitHubService {
        @FormUrlEncoded
        @POST("dnevnik/login")
    Call<Jlogin> getLog(@FieldMap Map<String, String> map);

 //    Call<Jlogin> getLog(@Body Jlogin jlogin);

        @FormUrlEncoded
        @POST("dnevnik/register")
    Call<Jregistr> getReg(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("dnevnik/register")
    Call<Jregistr> getGrup(@FieldMap Map<String, String> map);

}

