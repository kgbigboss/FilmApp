package com.geektech.filmapp.ui.films_detali;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geektech.filmapp.R;
import com.geektech.filmapp.databinding.FragmentFilmDetaliBinding;
import com.geektech.filmapp.databinding.FragmentFilmsBinding;


public class FilmDetaliFragment extends Fragment {

    private FragmentFilmDetaliBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetaliBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String image = requireArguments().getString("image");
        Glide.with(binding.imageView).load(image).circleCrop().into(binding.imageView);
        String title = requireArguments().getString("title");
        binding.tvDtlTitle.setText(title);
        String director = requireArguments().getString("director");
        binding.tvDirector.setText(director);
        String producer = requireArguments().getString("producer");
        binding.tvProducer.setText(producer);
        String release_date = requireArguments().getString("release_date");
        binding.tvReleaseDate.setText(release_date);


    }
}