package com.endava.rest;

/**
 * Created by astoica on 4/29/2015.
 */
public class BaseController {

    protected String user;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
