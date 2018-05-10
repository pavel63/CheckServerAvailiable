package com.example.ios_razrab.checkfirebaseavailiable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ErrorInterceptor())
                .build();

       Retrofit retrofit = new Retrofit.Builder()
       .client(client)
        .baseUrl("http://www.kasparov.ru/")
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

       ApiService apiService =retrofit .create(ApiService .class);

       Observable<Void> responseCall = apiService .checkServer();


       responseCall
               .subscribeOn(Schedulers .newThread())
               .repeat(5)
               .subscribe(new Consumer<Void>() {
                   @Override
                   public void accept(Void v) throws Exception {

                   }
               });

    //    retrofit .
    }
}
