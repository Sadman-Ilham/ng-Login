package com.sadman.nglogin.service;

import com.sadman.nglogin.enums.ResponseCode;
import com.sadman.nglogin.model.Response;
import com.sadman.nglogin.model.ResponseData;
import com.sadman.nglogin.model.User;
import com.sadman.nglogin.utils.UserDataManager;

/**
 * It registers a new {@code User}
 *
 * @author Sadman
 * @since Jul 29, 2016
 */
public class UserRegistrant {

    /**
     * It registers an {@code User} by saving the data
     *
     * @param   user
     * @return  {@code Response} with 201 if registration is successful,
     *          {@code Response} with 101 if {@code User} with similar user id already exists.
     */
    public Response register(User user) {
        if (!UserDataManager.checkExistence(user.getUserId())) {
            UserDataManager.save(user);
            return new Response(ResponseCode.REGISTRATION_SUCCESSFUL.getCode(), "Registration done successfully!");
        } else {
            return new Response(ResponseCode.OPERATION_FAILED.getCode(), "User id already exist!");
        }
    }

}
