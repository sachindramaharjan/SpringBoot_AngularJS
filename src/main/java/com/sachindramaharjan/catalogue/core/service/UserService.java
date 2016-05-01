package com.sachindramaharjan.catalogue.core.service;

import com.sachindramaharjan.catalogue.core.entity.User;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
public interface UserService {

    User findUserByUsername(String username);

    User findUserByEmail(String username);

    boolean isValidUser(User user);

    boolean changePassword(String username, String password, String newPassword);

    User addUser(User user);

    boolean deleteUser(Long id);

    User loginUser(User user);

}
