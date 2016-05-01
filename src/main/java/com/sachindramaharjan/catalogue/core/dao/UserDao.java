package com.sachindramaharjan.catalogue.core.dao;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
public interface UserDao<User> extends GenericDaoInterface<User> {

    User findByUsername(String username) throws Exception;
    User findByEmail(String email) throws  Exception;

}
