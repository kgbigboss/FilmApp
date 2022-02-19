package com.geektech.filmapp.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.filmapp.App;
import com.geektech.filmapp.R;
import com.geektech.filmapp.common.OnItemClick;
import com.geektech.filmapp.data.models.Film;
import com.geektech.filmapp.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment implements OnItemClick {
    private FragmentFilmsBinding binding;
    public FilmsAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = FragmentFilmsBinding.inflate(inflater,container,false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapter.setFilms(response.body());
                    Log.e("TAG","onResponse");
                }else {
                    Log.e("TAG","onResponse" + response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {

            }
        });


    }

    @Override
    public void onItemClick(Film film, String id) {
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null){
                    NavController navController = Navigation.findNavController(
                            requireActivity(),R.id.nav_host_fragment);
                    Bundle bundle = new Bundle();
                    bundle.putString("image",film.getMovieBanner());
                    bundle.putString("title", film.getTitle());
                    bundle.putString("director", film.getDirector());
                    bundle.putString("producer", film.getProducer());
                    bundle.putString("release_date", film.getReleaseDate());
                    navController.navigate(R.id.filmDetaliFragment,bundle);
            }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}