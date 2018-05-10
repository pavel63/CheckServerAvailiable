package com.example.ios_razrab.checkfirebaseavailiable;



import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {


    @GET("/")
    Observable<Void> checkServer();
}
