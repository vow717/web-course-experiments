package com.experiment5.entity;

import java.time.LocalDateTime;

public class DatabaseUtils {
    public static com.experiment5.entity.User getUser(String userName, String password){
        com.experiment5.entity.User user = null;
        if("wkf".equals(userName) && "123".equals(password))
        {
            user = new com.experiment5.entity.User("wkf", LocalDateTime.now());
        }
        return user;
    }
}
