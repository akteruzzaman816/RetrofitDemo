package com.akter.retrofitdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryData {
    @SerializedName("countryid")
    @Expose
    private String countryid;
    @SerializedName("CountryName")
    @Expose
    private String countryName;


    public CountryData(String countryid, String countryName) {
        super();
        this.countryid = countryid;
        this.countryName = countryName;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
