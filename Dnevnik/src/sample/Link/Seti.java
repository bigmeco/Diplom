package sample.Link;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Seti {
    private static final String URL = "https://dnevnik.gamekillers.ru/";


    public Jlogin Logining(String login,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Map<String,String> mapjs = new HashMap<String, String>();
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
    public void ResstrPr(String token){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Map<String,String> mapjs = new HashMap<String, String>();
        mapjs.put("token", "1ca97ded1c66a9b7368d1e558df836de");
        mapjs.put("login", "2");
        mapjs.put("password", "2");
        mapjs.put("name", "2");
        mapjs.put("lastname", "2");
        mapjs.put("midlename", "2");
        mapjs.put("type", "1");

        Call<Jregistr> call = service.getReg(mapjs);
        call.enqueue(new Callback<Jregistr>() {
            @Override
            public void onResponse(Call<Jregistr> call, Response<Jregistr> response) {
                System.out.println("StudentId  :  " + response.body().getStatus());
                System.out.println("StGFHFH  :  " + response.body().getInfo().getText());
            }

            @Override
            public void onFailure(Call<Jregistr> call, Throwable t) {
                System.out.println("onFailure");
            }
        });

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
