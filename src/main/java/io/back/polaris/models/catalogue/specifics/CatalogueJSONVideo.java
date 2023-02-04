package io.back.polaris.models.catalogue.specifics;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

import io.back.polaris.models.catalogue.CatalogueJSONItem;

public class CatalogueJSONVideo extends CatalogueJSONItem {

    @SerializedName(value = "release_date", alternate = {"first_air_date"})
    String releaseDate;

    @SerializedName(value = "genre_ids")
    Integer[] genreIds;

    @SerializedName(value = "overview")
    String overview;

    @SerializedName(value = "vote_average")
    Float voteAverage;

    @SerializedName(value = "vote_count")
    Integer voteCount;

    Boolean available = false;

    

    public String getReleaseDate() {
        return releaseDate;
    }



    public Integer[] getGenreIds() {
        return genreIds;
    }



    public String getOverview() {
        return overview;
    }



    public Float getVoteAverage() {
        return voteAverage;
    }



    public Integer getVoteCount() {
        return voteCount;
    }



    public Boolean getAvailable() {
        return available;
    }



    @Override
    public String toString() {
        return "CatalogueJSONVideo [releaseDate=" + releaseDate + ", genreIds=" + Arrays.toString(genreIds)
                + ", overview=" + overview + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount
                + ", available=" + available + "]";
    }
    
    
}
