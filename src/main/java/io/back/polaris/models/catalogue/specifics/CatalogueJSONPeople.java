package io.back.polaris.models.catalogue.specifics;

import com.google.gson.annotations.SerializedName;

import io.back.polaris.models.catalogue.CatalogueJSONItem;

public class CatalogueJSONPeople extends CatalogueJSONItem {
    
    @SerializedName(value = "gender")
    Integer gender;

    @SerializedName(value = "known_for_department")
    String knownForDepartment;

    

    public Integer getGender() {
        return gender;
    }



    public String getKnownForDepartment() {
        return knownForDepartment;
    }



    @Override
    public String toString() {
        return "CatalogueJSONPeople [gender=" + gender + ", knownForDepartment=" + knownForDepartment + "]";
    }

    
}
