package com.example.projectuas.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultResult {
    @SerializedName("status")
    @Expose
    String status;

    public DefaultResult(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}