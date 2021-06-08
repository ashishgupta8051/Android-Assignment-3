
package com.example.androidinternassignment.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Language {

    @SerializedName("iso639_1")
    private String mIso6391;
    @SerializedName("iso639_2")
    private String mIso6392;
    @SerializedName("name")
    private String mName;
    @SerializedName("nativeName")
    private String mNativeName;

    public String getIso6391() {
        return mIso6391;
    }

    public void setIso6391(String iso6391) {
        mIso6391 = iso6391;
    }

    public String getIso6392() {
        return mIso6392;
    }

    public void setIso6392(String iso6392) {
        mIso6392 = iso6392;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getNativeName() {
        return mNativeName;
    }

    public void setNativeName(String nativeName) {
        mNativeName = nativeName;
    }

}
