import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;


import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import rest.*;
import retrofit2.Call;
import io.reactivex.Observable;
import retrofit2.Response;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.Map;

import static com.sun.activation.registries.LogSupport.log;


/**
 * Created by bigme on 04.05.2017.
 */
public class Main {
    static Jlogin jloginO;
    public static void main(String[] args)   {

        intZapros call = new realZapros(new RetrofitServ().getRetrofit());
         String threadName = Thread.currentThread().getName();
        final Jlogin jlogin1 = new Jlogin();

        //System.out.println(jlogin[0].getInfo().getName());
        call.getLog("admin","password")
                .observeOn(Schedulers.io())
                .subscribe(s -> Main.getJlog(s));

       // System.out.println(intlog.sst());
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
    public static void getJlog(Jlogin jlogin) {
        jloginO = jlogin;
        System.out.println(jlogin.getToken());
    }





}

