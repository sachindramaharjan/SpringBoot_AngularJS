package com.sachindramaharjan.catalogue.test.service;

import com.sachindramaharjan.catalogue.core.dao.UserDao;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.exception.UserExistException;
import com.sachindramaharjan.catalogue.core.service.UserService;
import com.sachindramaharjan.catalogue.test.SpringTestConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachindra.maharjan on 4/25/16.
 */
public class UserServiceTest extends SpringTestConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    User user = null;


    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("sachindra");
        user.setPassword("maharjan");
        user.setActivate_fl(true);
        user.setEmail("sachindra.maharjan@gmail.com");
        userDao.save(user);
    }

    @Test
    @Transactional
    public void testAddUser() throws Exception{
        User user1 = new User();
        user1.setUsername("rukesh");
        user1.setPassword("password");
        user1.setEmail("rukesh.maharjan@gmail.com");
        user1.setActivate_fl(true);

        try {
            User newUser = userService.addUser(user1);
            Assert.assertNotNull(newUser);

        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new UserExistException(ex.getMessage());
        }
    }




}
