package io.back.polaris.models.catalogue;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CatalogueJSONList {
    
    @SerializedName(value = "page")
    Integer page;

    @SerializedName(value = "total_pages")
    Integer totalPages;

    @SerializedName(value = "total_results")
    Integer totalResults;

    @SerializedName(value = "results")
    List<CatalogueJSONItem> results;

    String keyword;

    
    public CatalogueJSONList() {
    }

    public CatalogueJSONList(Integer page, Integer totalPages, Integer totalResults, List<CatalogueJSONItem> results) {
        this.page = page;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }



    public Integer getTotalPages() {
        return totalPages;
    }



    public Integer getTotalResults() {
        return totalResults;
    }



    public List<CatalogueJSONItem> getResults() {
        return results;
    }

    


    public String getKeyword() {
        return keyword;
    }



    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }



    @Override
    public String toString() {
        return "CatalogueJSONList [page=" + page + ", totalPages=" + totalPages + ", totalResults=" + totalResults
                + ", results=" + results.toString() + "]";
    }
    
}
