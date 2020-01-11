package com.hit.model;

import java.util.List;

public class UserResponse {
    private boolean error;
    private List<User> users;

    public UserResponse(boolean error, List<User> users) {
        this.error = error;
        this.users = users;
    }

    public boolean isError() {
        return error;
    }

    public List<User> getUsers() {
        return users;
    }
}
