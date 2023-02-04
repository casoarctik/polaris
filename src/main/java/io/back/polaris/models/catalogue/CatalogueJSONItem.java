package io.back.polaris.models.catalogue;

import com.google.gson.annotations.SerializedName;

public abstract class CatalogueJSONItem {
    
    @SerializedName(value = "id")
    Integer id;

    @SerializedName(value = "media_type")
    String mediaType;

    @SerializedName(value = "popularity")
    Float popularity;

    @SerializedName(value = "name", alternate = {"title"})
    String name;

    @SerializedName(value = "poster_path", alternate = {"profile_path"})
    String imagePath;


    
    public Integer getId() {
        return id;
    }



    public String getMediaType() {
        return mediaType;
    }



    public Float getPopularity() {
        return popularity;
    }



    public String getName() {
        return name;
    }



    public String getImagePath() {
        return imagePath;
    }



    @Override
    public String toString() {
        return "CatalogueJSONItem [id=" + id + ", mediaType=" + mediaType + ", popularity=" + popularity + ", name="
                + name + ", imagePath=" + imagePath + "]";
    }

    
}
