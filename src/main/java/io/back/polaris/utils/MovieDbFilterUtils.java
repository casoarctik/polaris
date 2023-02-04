package io.back.polaris.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.back.polaris.models.catalogue.CatalogueJSONItem;
import io.back.polaris.models.catalogue.specifics.CatalogueJSONVideo;

public class MovieDbFilterUtils {
    
    public List<CatalogueJSONItem> prefilter(List<CatalogueJSONItem> allResults){
        List<CatalogueJSONItem> itemsToRemove = new ArrayList<>();
        for (CatalogueJSONItem item : allResults) {
            if(!item.getMediaType().equals("person")){
                try {
                    itemsToRemove.add(prefilterDate(item));
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        allResults.removeAll(itemsToRemove);
        return allResults;
        
    }

    private CatalogueJSONVideo prefilterDate(CatalogueJSONItem item) throws ParseException{
        CatalogueJSONVideo videoItem = (CatalogueJSONVideo) item;
        if(videoItem.getReleaseDate() != null && !videoItem.getReleaseDate().isBlank()){

            Date realaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(videoItem.getReleaseDate());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(realaseDate);

            boolean isAMovie = videoItem.getMediaType().equals("movie");
            
            return (isAMovie ? prefilterDateMovie(videoItem, calendar) : prefilterDateSerie(videoItem, calendar));

        } else {
            return videoItem;
        }
    }

    private CatalogueJSONVideo prefilterDateMovie(CatalogueJSONVideo movie, Calendar calendar){
        calendar.add(Calendar.MONTH, 4);
            
        if (calendar.getTime().after(new Date())) {
            return movie;
        }
        return null;
    }

    private CatalogueJSONVideo prefilterDateSerie(CatalogueJSONVideo serie, Calendar calendar){
           
        if (calendar.getTime().after(new Date())) {
            return serie;
        }
        return null;
    }


}
