package io.back.polaris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "serie", schema = "polaris_db_a")
public class Serie extends Item{
    
    @Column(name = "tmdb_id", nullable = false)
    private Long tmdbId;

    @Column(name = "episodes_count", nullable = false)
    private int episodesNb;

    @Column(name = "season_count", nullable = false)
    private int seasonNb;

    public Serie(String title, Ticket ticket, String path, Category category) {
        super(title, ticket, path, category);
    }

    public Serie(String title, Ticket ticket, String path, Category category, Long tmdbId, int episodesNb, int seasonNb) {
        super(title, ticket, path, category);
        this.tmdbId = tmdbId;
        this.episodesNb = episodesNb;
        this.seasonNb = seasonNb;
    }

    public Long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Long tmdbId) {
        this.tmdbId = tmdbId;
    }

    public int getEpisodesNb() {
        return episodesNb;
    }

    public void setEpisodesNb(int episodesNb) {
        this.episodesNb = episodesNb;
    }

    public int getSeasonNb() {
        return seasonNb;
    }

    public void setSeasonNb(int seasonNb) {
        this.seasonNb = seasonNb;
    }

    
    

}
