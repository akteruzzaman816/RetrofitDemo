package com.akter.retrofitdemo.modelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FlowerResponse {


    @SerializedName("flowerlist")
    @Expose
    private List<FlowerData> flowerlist = null;

    public FlowerResponse(List<FlowerData> flowerlist) {
        super();
        this.flowerlist = flowerlist;
    }

    public List<FlowerData> getFlowerlist() {
        return flowerlist;
    }

    public void setFlowerlist(List<FlowerData> flowerlist) {
        this.flowerlist = flowerlist;
    }

}
