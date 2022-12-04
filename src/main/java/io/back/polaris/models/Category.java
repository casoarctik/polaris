package io.back.polaris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category", schema = "polaris_db_a")
public enum Category {
    FILM(0, "FILM"),
    SERIE, 
    EPISODE, 
    LOGICIEL;

    @Id
    @Enumerated(EnumType.ORDINAL)
    public int id;

    
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    public String categoryName;
  
    private Category() {
    }

    private Category(int id, String name){
        this.id = id;
        this.categoryName = name;
    }

    public String getCategory() {
        return categoryName;
    }    
}
