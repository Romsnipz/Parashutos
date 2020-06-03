package spring.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserHTTPPojo {

    @JsonProperty(value = "User_Email")
    private String userEmail;

    @JsonProperty(value = "User_Nickname")
    private String userNickname;

    @JsonProperty(value = "User_Password")
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

    @Override
    public String toString() {
        return "UserHTTPPojo{" +
                "User_Email='" + userEmail + '\'' +
                ", User_Nickname='" + userNickname + '\'' +
                ", User_Password='" + userPassword + '\'' +
                '}';
    }
}
