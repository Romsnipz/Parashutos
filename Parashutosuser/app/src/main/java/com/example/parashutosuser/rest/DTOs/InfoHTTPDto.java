package com.example.parashutosuser.rest.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InfoHTTPDto implements Serializable {

    @SerializedName("User_Nickname")
    @Expose
    private String userNickname;

    @SerializedName("SurName")
    @Expose
    private String surName;

    @SerializedName("FirstName")
    @Expose
    private String firstName;

    @SerializedName("SecondName")
    @Expose
    private String secondName;

    @SerializedName("Birthday")
    @Expose
    private Long birthday;

    @SerializedName("City")
    @Expose
    private String city;

    @SerializedName("Dropzone")
    @Expose
    private String dropzone;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDropzone() {
        return dropzone;
    }

    public void setDropzone(String dropzone) {
        this.dropzone = dropzone;
    }
}
