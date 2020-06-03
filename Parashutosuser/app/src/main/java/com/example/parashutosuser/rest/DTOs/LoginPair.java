package com.example.parashutosuser.rest.DTOs;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPair {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("client")
    @Expose
    private UserHTTPDto user;

    @SerializedName("info")
    @Expose
    private InfoHTTPDto info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserHTTPDto getUser() {
        return user;
    }

    public void setUser(UserHTTPDto user) {
        this.user = user;
    }

    public InfoHTTPDto getInfo() {
        return info;
    }

    public void setInfo(InfoHTTPDto info) {
        this.info = info;
    }
}
