package com.pg5100_Reddit.controller;

import com.pg5100_Reddit.ejb.UserEJB;

import javax.ejb.EJB;

public class userController {

    @EJB
    private UserEJB userEJB;

    private String userId;
    private String name;
    private String surName;

    public void createUser(){
        userEJB.createNewUser(userId, name, surName);
        clear();
    }

    private void clear() {
        userId = "";
        name = "";
        surName = "";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
