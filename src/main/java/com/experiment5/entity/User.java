package com.experiment5.entity;

import java.time.LocalDateTime;
public class User {
    private String name;
    private LocalDateTime logintime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLogintime() {
        return logintime;
    }

    public void setLogintime(LocalDateTime logintime) {
        this.logintime = logintime;
    }

    public User(String name, LocalDateTime logintime) {
        this.name = name;
        this.logintime = logintime;
    }
}
