package sample.Link;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Seti {
    private static final String URL = "https://dnevnik.gamekillers.ru/";


    public Jlogin Logining(String login, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Map<String, String> mapjs = new HashMap<String, String>();
        mapjs.put("login", "admin");
        mapjs.put("password", "password");
        Call<Jlogin> call = service.getLog(mapjs);
        Response<Jlogin> response = null;
        try {
            response = call.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Jlogin map = response.body();
        return map;
//        call.enqueue(new Callback<Jlogin>() {
//
//            @Override
//            public void onResponse(Call<Jlogin> call, Response<Jlogin> response) {
//            }
//            @Override
//            public void onFailure(Call<Jlogin> call, Throwable t) {
//            }
//        });
//        return call;
    }

    public Jregistr ResstrPr(Map<String, String> mapjs) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);


        Call<Jregistr> call = service.getReg(mapjs);
        Response<Jregistr> response = null;
        try {
            response = call.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Jregistr map = response.body();
        return map;

        // НЕ РАБОТАЕТ (ОСТАВЛЮ ЧТОБ ПОТОМ НЕ ВТАВАТЬ НА ТЕЖЕ ГРАБЛИ)
//        try {
//            response = call.execute();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String F = String.valueOf(response.body());
//        String g ;
//        //F = "{status=0, info={text=FDG FDG HDF}}";
//        System.out.println(F);

//        Map<String,String> map = GSON.fromJson(F,Map.class);
//        for (Map.Entry e : map.entrySet()){
//           System.out.println(e.getKey()+" "+e.getValue());
//        }
//        Map<String,String> map = GSON.fromJson(response.body().toString(),Map.class);
//        for (Map.Entry e : map.entrySet()){
//           System.out.println(e.getKey()+" "+e.getValue());}
//    Jregistr map = GSON.fromJson(response.body().toString(), Jregistr.class);
//       System.out.println(map.getStatus()+" ggggggg");

    }
}
