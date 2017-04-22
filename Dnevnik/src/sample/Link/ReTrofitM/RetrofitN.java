package sample.Link.ReTrofitM;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bigi on 22.04.2017.
 */
public class RetrofitN {
    private static final String URL = "https://dnevnik.gamekillers.ru/";
    public GitHubService RetrofMod (){
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        return service;
    }
}
