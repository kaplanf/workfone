package com.redtulip.workfone.restful.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginModel implements Serializable {

    @SerializedName("id")
    public String id;

    @SerializedName("ttl")
    public int ttl;

    @SerializedName("userId")
    public int userId;

    @SerializedName("created")
    public String created;

    public static class LoginRequest {
        @SerializedName("email")
        public String email;

        @SerializedName("password")
        public String password;
    }
}
