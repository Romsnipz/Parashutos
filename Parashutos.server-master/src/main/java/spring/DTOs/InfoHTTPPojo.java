package spring.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import spring.hibernate.entity.UserReg;

import javax.persistence.Column;
import java.util.Date;

public class InfoHTTPPojo {

    @JsonProperty(value = "User_Nickname")
    private String userNickname;

    @JsonProperty(value = "SurName")
    private String surName;

    @JsonProperty(value = "FirstName")
    private String firstName;

    @JsonProperty(value = "SecondName")
    private String secondName;

    @JsonProperty(value = "Birthday")
    private Date birthday;

    @JsonProperty(value = "City")
    private String city;

    @JsonProperty(value = "Dropzone")
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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