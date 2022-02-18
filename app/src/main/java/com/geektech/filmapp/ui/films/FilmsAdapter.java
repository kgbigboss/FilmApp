package com.geektech.filmapp.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.filmapp.common.OnItemClick;
import com.geektech.filmapp.data.models.Film;
import com.geektech.filmapp.databinding.ItemFilmsBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private List<Film> films = new ArrayList<>();
    public OnItemClick<String> listener;

    public void setListener(OnItemClick<String> listener) {
        this.listener = listener;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmsBinding binding = ItemFilmsBinding.inflate(LayoutInflater.from(
                parent.getContext()),parent,false);
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(films.get(holder.getAdapterPosition()).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected class FilmsViewHolder extends RecyclerView.ViewHolder{

        private ItemFilmsBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());
        }
    }

}
