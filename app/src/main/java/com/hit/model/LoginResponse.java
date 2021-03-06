package com.hit.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String msg;
    private User user;

    public LoginResponse(boolean error, String msg, User user) {
        this.error = error;
        this.msg = msg;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public User getUser() {
        return user;
    }
}
