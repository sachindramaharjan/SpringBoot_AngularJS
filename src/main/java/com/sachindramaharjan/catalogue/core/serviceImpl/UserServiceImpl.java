package com.sachindramaharjan.catalogue.core.serviceImpl;

import com.sachindramaharjan.catalogue.core.dao.UserDao;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.exception.NotFoundException;
import com.sachindramaharjan.catalogue.core.exception.UserExistException;
import com.sachindramaharjan.catalogue.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsername(String username){
        try {
            return (User) userDao.findByUsername(username);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public User findUserByEmail(String email) {
        try{
            return (User) userDao.findByEmail(email);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }

    }

    @Override
    public boolean isValidUser(User user) {
        if(userDao.find(user) != null){
            return true;
        }

        return false;
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword) {

        try{
            User user = (User) userDao.findByUsername(username);

            if(BCrypt.checkpw(password, user.getPassword())){
                user.setPassword(generateHashedPassword(newPassword));
                userDao.update(user);
                return true;
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new NotFoundException("User not found");
        }

        return false;
    }

    @Override
    public User addUser(User user) {
        if("".equals(user.getUsername().trim()) ||
                "".equals(user.getPassword().trim()) ||
                        "".equals(user.getEmail().trim())){
            return null;
        }

        if(findUserByUsername(user.getUsername()) != null)
            throw new UserExistException("User already exists with username ("+user.getUsername()+").");
        if(findUserByEmail(user.getEmail()) != null)
            throw new UserExistException("User already exists with email ("+user.getEmail()+").");

        user.setPassword(generateHashedPassword(user.getPassword()));

        return (User) userDao.save(user);

    }

    @Override
    public boolean deleteUser(Long id) {
        User user = (User) userDao.find(id);
        if(user != null){
            return userDao.delete(user);
        }else{
            throw new NotFoundException("User not found");
        }
    }

    public String generateHashedPassword(String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashed;
    }

    @Override
    public User loginUser(User user) {
        if("".equals(user.getUsername()) || "".equals(user.getPassword())){
            return null;
        }

        try{
            User currentUser = (User) userDao.findByUsername(user.getUsername());

            if(currentUser == null){
                currentUser = (User) userDao.findByEmail(user.getEmail());
            }

            if(BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
                return user;
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new NotFoundException("User not found");
        }

        return null;
    }
}
