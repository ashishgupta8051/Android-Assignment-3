
package com.example.androidinternassignment.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CountryDetails {

    @SerializedName("name")
    private String mName;
    @SerializedName("capital")
    private String mCapital;
    @SerializedName("region")
    private String mRegion;
    @SerializedName("subregion")
    private String mSubregion;
    @SerializedName("population")
    private Long mPopulation;
    @SerializedName("flag")
    private String mFlag;
    @SerializedName("borders")
    private List<String> borders;
    @SerializedName("languages")
    private List<Language> languages;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCapital() {
        return mCapital;
    }

    public void setmCapital(String mCapital) {
        this.mCapital = mCapital;
    }

    public String getmRegion() {
        return mRegion;
    }

    public void setmRegion(String mRegion) {
        this.mRegion = mRegion;
    }

    public String getmSubregion() {
        return mSubregion;
    }

    public void setmSubregion(String mSubregion) {
        this.mSubregion = mSubregion;
    }

    public Long getmPopulation() {
        return mPopulation;
    }

    public void setmPopulation(Long mPopulation) {
        this.mPopulation = mPopulation;
    }

    public String getmFlag() {
        return mFlag;
    }

    public void setmFlag(String mFlag) {
        this.mFlag = mFlag;
    }


    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
