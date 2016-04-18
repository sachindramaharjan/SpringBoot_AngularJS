package com.sachindramaharjan.catalogue.core.serviceImpl;

import com.sachindramaharjan.catalogue.core.dao.UserDaoInterface;
import com.sachindramaharjan.catalogue.core.daoImpl.UserDaoImpl;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.exception.UserExistException;
import com.sachindramaharjan.catalogue.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoInterface userDaoInterface;

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserByEmail(String username) {
        return null;
    }

    @Override
    public User loginUser(User user) {
        return user;
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword) {
        return false;
    }

    @Override
    public User addUser(User user) {
        if(findUserByUsername(user.getUsername()) != null)
            throw new UserExistException("User already exists with username ("+user.getUsername()+").");
        if(findUserByEmail(user.getEmail()) != null)
            throw new UserExistException("User already exists with email ("+user.getEmail()+").");

        return (User)userDaoInterface.save(user);

    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }
}
