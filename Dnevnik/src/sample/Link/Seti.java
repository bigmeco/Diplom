package sample.Link;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Seti {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String URL = "https://dnevnik.gamekillers.ru/";
    private static String TOKIN ;
    private static int STATYS ;
    private static String id;
    private static String name;
    private static String lastname;
    private static String midlename;

    public Jlogin Logining(String login,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println("Hello World!");
        //retrofit.create(GitHubService.class)
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
        String F = response.body().toString();
        System.out.println(F);
        Jlogin map = response.body();
        System.out.println(map.getInfo().getLastname());
        return map;
//        call.enqueue(new Callback<Jlogin>() {
//
//            @Override
//            public void onResponse(Call<Jlogin> call, Response<Jlogin> response) {
//                TOKIN = response.body().getToken();
//                STATYS = response.body().getStatus();
//            }
//
//            @Override
//            public void onFailure(Call<Jlogin> call, Throwable t) {
//
//            }
//        });
//
//
//        return call;
    }
    public void ResstrPr(String token){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println("Hello World!");
        //retrofit.create(GitHubService.class)
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
