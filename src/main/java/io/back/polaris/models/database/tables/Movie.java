package io.back.polaris.models.database.tables;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import io.back.polaris.models.database.generics.Item;

@Entity
@Table(name = "movie", schema = "polaris_db_a")
public class Movie extends Item {
    
    @Column(name = "tmdb_id", nullable = false)
    private Long tmdbId;

    public Movie(String title, Ticket ticket, String path) {
        super(title, ticket, path);
    }

    public Movie(String title, Ticket ticket, String path, Long tmdbId) {
        super(title, ticket, path);
        this.tmdbId = tmdbId;
      
    }

    public Long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Long tmdbId) {
        this.tmdbId = tmdbId;
    }

    
    
}
