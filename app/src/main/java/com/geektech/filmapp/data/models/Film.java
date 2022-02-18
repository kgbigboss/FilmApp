package com.geektech.filmapp.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id")
     String id;
    @SerializedName("title")
     String title;
     @SerializedName("original_title")
     String originalTitle;
     @SerializedName("description")
     String description;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDescription() {
        return description;
    }
}
