package com.sachindramaharjan.catalogue.core.service;

import com.sachindramaharjan.catalogue.core.entity.User;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
public interface UserService {

    public User findUserByUsername(String username);

    public User findUserByEmail(String username);

    public User loginUser(User user);

    public boolean changePassword(String username, String password, String newPassword);

    public User addUser(User user);

    public User deleteUser(Long id);

}
