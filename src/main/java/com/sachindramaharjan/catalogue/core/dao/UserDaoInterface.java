package com.sachindramaharjan.catalogue.core.dao;

import com.sachindramaharjan.catalogue.core.daoImpl.GenericDaoImpl;
import com.sachindramaharjan.catalogue.core.entity.User;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
public interface UserDaoInterface<User> extends GenericDaoInterface<User> {

    User findByUsername(String username);
    User findByEmail(String email);

}
