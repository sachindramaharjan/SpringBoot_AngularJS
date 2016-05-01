package com.sachindramaharjan.catalogue.test.dao;

import com.sachindramaharjan.catalogue.core.dao.UserDao;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.test.SpringTestConfiguration;
import org.junit.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachindra.maharjan on 4/25/16.
 */

public class UserDaoTest extends SpringTestConfiguration {

    @Autowired
    private UserDao userDoa;

    private User user;

    @Before
    @Transactional
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("sachindra");
        user.setPassword("maharjan");
        user.setActivate_fl(true);
        user.setEmail("sachindra.maharjan@gmail.com");
        userDoa.save(user);
    }

    @Test
    @Transactional
    public void testAddUser() throws Exception {

        User newUser = (User)userDoa.save(user);
        Assert.assertNotNull(newUser);
        Assert.assertEquals(user.getUsername(), newUser.getUsername());
    }

    @Test
    @Transactional
    public void testUpdateUser() throws Exception {
        User newUser = (User)userDoa.save(user);
        newUser.setPassword("updatePassword");
        User updateUser = (User) userDoa.update(newUser);
        Assert.assertNotNull(updateUser);
        Assert.assertEquals(updateUser.getPassword(), "updatePassword");
    }

    @Test
    @Transactional
    public void testFindUser() throws Exception{
        User findUser = (User)userDoa.find(user.getId());
        Assert.assertNotNull(findUser);
        Assert.assertEquals(findUser.getUsername(), user.getUsername());
    }

    @Test
    @Transactional
    public void testFindUserByUsername() throws Exception{
        User findUser = (User)userDoa.findByUsername(user.getUsername());
        Assert.assertNotNull(findUser);
        Assert.assertEquals(findUser.getUsername(), user.getUsername());
    }

    @Test
    @Transactional
    public void testFindUserByEmail() throws Exception{
        User findUser = (User)userDoa.findByEmail(user.getEmail());
        Assert.assertNotNull(findUser);
        Assert.assertEquals(findUser.getUsername(), user.getUsername());
        Assert.assertEquals(findUser.getId(), user.getId());
    }

    @Test
    @Transactional
    public void testDeleteUser() throws Exception{
        userDoa.delete(user);

        Assert.assertNull(userDoa.find(user.getId()));

    }

}
