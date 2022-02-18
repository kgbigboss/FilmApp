package com.geektech.filmapp.data.remote;

import com.geektech.filmapp.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();

}
