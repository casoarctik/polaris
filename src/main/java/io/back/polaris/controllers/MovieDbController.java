package io.back.polaris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.back.polaris.models.catalogue.CatalogueJSONList;
import io.back.polaris.services.MovieDbService;


@RestController
@RequestMapping("/movieDb")
public class MovieDbController {
    
    @Autowired
    MovieDbService movieDbService;

    @GetMapping("/search")
    public CatalogueJSONList searchByKeyWord(@RequestParam String word){
        return movieDbService.findResultByKeyWord(word);
    }
    
    @GetMapping("/nextPage")
    public CatalogueJSONList nextPage(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return movieDbService.createPage(pageNumber, pageSize);
    }
    
}
