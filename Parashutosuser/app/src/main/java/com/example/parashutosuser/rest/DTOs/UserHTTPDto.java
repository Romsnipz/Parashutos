package com.example.parashutosuser.rest.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserHTTPDto implements Serializable {
    @SerializedName("User_Email")
    @Expose
    private String userEmail;

    @SerializedName("User_Nickname")
    @Expose
    private String userNickname;

    @SerializedName("User_Password")
    @Expose
    private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
