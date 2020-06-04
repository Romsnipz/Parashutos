package com.example.parashutosuser;

import com.example.parashutosuser.rest.DTOs.InfoHTTPDto;
import com.example.parashutosuser.rest.DTOs.UserHTTPDto;

public class Saveclass {

    static UserHTTPDto user;
    static InfoHTTPDto info;

    public static UserHTTPDto getUser() {
        return user;
    }

    public static void setUser(UserHTTPDto user) {
        Saveclass.user = user;
    }

    public static InfoHTTPDto getInfo() {
        return info;
    }

    public static void setInfo(InfoHTTPDto info) {
        Saveclass.info = info;
    }

}
