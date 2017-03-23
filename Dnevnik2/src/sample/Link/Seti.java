package sample.Link;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Seti {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String URL = "https://dnevnik.gamekillers.ru/";

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
        // Jlogin jlogin = new Jlogin("admin","password");
        //   Call<Jlogin> call = service.getLog(jlogin);
        Call<Object> call = service.getLog(mapjs);
        Response<Object> response = null;
        try {

            response = call.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String F = response.body().toString();
        System.out.println(F);
        Jlogin map = GSON.fromJson(response.body().toString(), Jlogin.class);
        System.out.println(map.getInfo().getLastname());
        return map;
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
        // Jlogin jlogin = new Jlogin("admin","password");
        //   Call<Jlogin> call = service.getLog(jlogin);
        Call<Object> call = service.getReg(mapjs);
        Response<Object> response = null;

        try {
            response = call.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
       Gson GSON1 = new Gson();
        String F = response.body().toString();
        //F = "{status=0, info={text=FDG FDG HDF}}";
        System.out.println(F);
        
        Map<String,String> map = GSON1.fromJson(F,Map.class);
        for (Map.Entry e : map.entrySet()){
           System.out.println(e.getKey()+" "+e.getValue());}


//        Map<String,String> map = GSON.fromJson(response.body().toString(),Map.class);
//        for (Map.Entry e : map.entrySet()){
//           System.out.println(e.getKey()+" "+e.getValue());}
  //  Jregistr map = GSON.fromJson(response.body().toString(), Jregistr.class);
  //     System.out.println(map.getStatus()+" ggggggg");

    }
}
