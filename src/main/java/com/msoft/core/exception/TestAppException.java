package com.msoft.core.exception;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

/**
 * @author ManhKM on 1/12/2023
 * @project cicd-tutorial
 */
public class TestAppException {

    public User getUser(String username){

        User user = null;
        if(user.equals(null)){
            throw new AppException(404, "User not found");
        }
        return user;
    }
}
