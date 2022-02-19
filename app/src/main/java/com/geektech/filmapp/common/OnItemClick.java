package com.geektech.filmapp.common;

import com.geektech.filmapp.data.models.Film;

public interface OnItemClick<T> {
    void onItemClick(Film film, String id);
}
