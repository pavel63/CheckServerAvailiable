package com.example.ios_razrab.checkfirebaseavailiable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        .build();

       ApiService apiService =retrofit .create(ApiService .class);

       Call<Void> responseCall = apiService .checkServer();

       responseCall .enqueue(new Callback<Void>() {
           @Override
           public void onResponse(Call<Void> call, Response<Void> response) {

           }

           @Override
           public void onFailure(Call<Void> call, Throwable t) {

           }
       });

    //    retrofit .
    }
}
