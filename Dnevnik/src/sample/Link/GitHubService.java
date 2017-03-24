package sample.Link;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * Created by bigi on 05.03.2017.
 */

public interface GitHubService {
        @FormUrlEncoded
        @POST("dnevnik/login")
    Call<Object> getLog(@FieldMap Map<String, String> map);

 //    Call<Jlogin> getLog(@Body Jlogin jlogin);

        @FormUrlEncoded
        @POST("dnevnik/register")
    Call<Object> getReg(@FieldMap Map<String, String> map);

}

