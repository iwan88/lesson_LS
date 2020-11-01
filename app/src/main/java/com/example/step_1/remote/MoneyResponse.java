package com.example.step_1.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoneyResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private List<MoneyRemoteItem> MoneyItemsList;

    public String getStatus() {
        return status;
    }

    public List<MoneyRemoteItem> getMoneyItemsList() {
        return MoneyItemsList;
    }
}
