package com.geektech.filmapp;

import android.app.Application;

import com.geektech.filmapp.data.remote.FilmApi;
import com.geektech.filmapp.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }
}
