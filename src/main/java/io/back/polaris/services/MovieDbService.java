package io.back.polaris.services;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;

import io.back.polaris.models.catalogue.CatalogueJSONItem;
import io.back.polaris.models.catalogue.CatalogueJSONList;
import io.back.polaris.models.catalogue.specifics.CatalogueJSONPeople;
import io.back.polaris.models.catalogue.specifics.CatalogueJSONVideo;
import io.back.polaris.utils.MovieDbFilterUtils;



@Service
public class MovieDbService {
    
    MovieDbFilterUtils movieDbFilterUtils  = new MovieDbFilterUtils();

    static final String URL = "https://api.themoviedb.org/3/search/multi?api_key=61a43e9873dd19405bd314bb17b746d2&language=fr-FR&query=[query]&page=1&include_adult=false"; 

    List<CatalogueJSONItem> allResults;

    /**
     * 
     * @param keyword
     * @return
     */
    public CatalogueJSONList findResultByKeyWord(String keyword){

        this.allResults = new ArrayList<>();
        CatalogueJSONList catalogueJSONList = new CatalogueJSONList();
        
        catalogueJSONList = getJSON(catalogueJSONList, keyword, null);

        catalogueJSONList = getAllResult(catalogueJSONList, keyword);
        catalogueJSONList.setKeyword(keyword);
        return catalogueJSONList;

    }

    /**
     * 
     * @param catalogueJSONList
     * @param keyword
     * @param page
     * @return
     */
    private CatalogueJSONList getJSON(CatalogueJSONList catalogueJSONList, String keyword, Integer page){
        try {

            JsonReader reader = new JsonReader(new InputStreamReader(new URL(controlKeyWord(keyword, page)).openStream(), StandardCharsets.UTF_8));
            Gson gson = new GsonBuilder().registerTypeAdapter(CatalogueJSONItem.class, new JsonDeserializer<CatalogueJSONItem>() {
                public CatalogueJSONItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    JsonObject jsonObject = json.getAsJsonObject();
                    String mediaType = jsonObject.get("media_type").getAsString();
                    if(mediaType.equals("person")){
                        return context.deserialize(jsonObject, CatalogueJSONPeople.class);
                    }else{
                        return context.deserialize(jsonObject, CatalogueJSONVideo.class);
                    }
                        
                }
            }).create(); 
                
            catalogueJSONList = gson.fromJson(reader, CatalogueJSONList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return catalogueJSONList;
    }

    /**
     * 
     * @param keyword
     * @param page
     * @return
     */
    private String controlKeyWord(String keyword, Integer page){
        String uri = URL;
        if(keyword.contains(" ")){
            keyword = keyword.replace(" ", "%20");
        }

        if(page != null){
            uri = uri.replace("page=1", "page="+page);
        }

        uri = uri.replace("[query]", keyword);

        return uri;
    }

    /**
     * 
     * @param catalogueJSONList
     * @param keyword
     * @return
     */
    private CatalogueJSONList getAllResult(CatalogueJSONList catalogueJSONList, String keyword){

        this.allResults.addAll(catalogueJSONList.getResults());

        if(catalogueJSONList.getTotalPages() > 1){
            for(int i = 2; i <= catalogueJSONList.getTotalPages(); i++){

                CatalogueJSONList newPageResults = new CatalogueJSONList();
                newPageResults = getJSON(catalogueJSONList, keyword, i);
                this.allResults.addAll(newPageResults.getResults());
            }
        }
        
        this.allResults = movieDbFilterUtils.prefilter(this.allResults);
        int pageSize = this.allResults.size() < 10 ? this.allResults.size() : 10;
        return createPage(1, pageSize);
        
    }

    /**
     * 
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public CatalogueJSONList createPage(int pageNumber, int pageSize){
        
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        int totalResults = this.allResults.size();
        int totalPages = (int) Math.ceil((double) totalResults / pageSize);
        List<CatalogueJSONItem> resultsPage = this.allResults.subList(fromIndex, toIndex);
        return new CatalogueJSONList(
            pageNumber,
            totalPages,
            totalResults,
            resultsPage);
        
    }

}
