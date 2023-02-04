package io.back.polaris.models.enums;

public enum Category {

    UNKNOW(0, "inconnu"),
    FILM(1, "film"),
    SERIE(2, "série"),
    SEASON(3, "saison"),
    EPISODE(4, "épisode"), 
    SOFTWARE(5, "logiciel"),
    GAME(6, "jeu vidéo");

    private Category(Integer id, String code){
        this.id = id;
        this.code = code;
    }
    private final Integer id;

    private final String code;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
  
    public static Category getCategoryById(Integer id){
        Category category = Category.UNKNOW;
        for (Category targetCategory : Category.values()) {
            if(targetCategory.getId().equals(id)){
                category = targetCategory;
            }
        }
        return category;
    }

}
