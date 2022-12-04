package io.back.polaris.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "movie", schema = "polaris_db_a")
public class Movie extends Item {
    
    @Column(name = "tmdb_id", nullable = false)
    private Long tmdbId;

    public Movie(String title, Ticket ticket, String path, Category category) {
        super(title, ticket, path, category);
    }

    public Movie(String title, Ticket ticket, String path, Category category, Long tmdbId) {
        super(title, ticket, path, category);
        this.tmdbId = tmdbId;
      
    }


    public Long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Long tmdbId) {
        this.tmdbId = tmdbId;
    }

    
    
}
