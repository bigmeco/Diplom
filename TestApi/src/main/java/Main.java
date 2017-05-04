import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rest.Jlogin;
import rest.RetrofitServ;
import rest.intZapros;
import rest.realZapros;
import retrofit2.Call;
import io.reactivex.Observable;
import retrofit2.Response;

import java.io.IOException;

import static com.sun.activation.registries.LogSupport.log;


/**
 * Created by bigme on 04.05.2017.
 */
public class Main {

    public static void main(String[] args)  {
        final String s ;
        intZapros call = new realZapros(new RetrofitServ().getRetrofit());
        //Call<Jlogin> call = service.getLog(mapjs);
 Jlogin f ;
                call.getLog("admin","password")
                        .map(p-> p.getStatus())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(Schedulers.start())
                        .subscribe(p -> System.out.println(p));

//                        .subscribeOn(Schedulers.io())
//                        .observeOn(Schedulers.io())
//                        .map(Jlogin::getInfo)
//                        //.map(Jlogin::getInfo)
//                        .subscribe(p->  s[0] =p.getName());

        //System.out.println(s[0]);
//        Observer<Jlogin> observer = new Observer<Jlogin>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Jlogin s) {
//                log("onNext: " + s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                log("onError: " + e);
//            }
//
//            @Override
//            public void onComplete() {
//                log("onCompleted");
//            }
//        };
//        call.getLog("admin","password")
//.getLog("admin","password");
    }

}