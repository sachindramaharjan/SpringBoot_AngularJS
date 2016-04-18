package com.sachindramaharjan.catalogue.core.daoImpl;

import com.sachindramaharjan.catalogue.core.dao.UserDaoInterface;
import com.sachindramaharjan.catalogue.core.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDaoInterface{

    private String hqlQuery;

    public UserDaoImpl(){
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        hqlQuery = "SELECT u from User u WHERE u.username = :username";
        TypedQuery<User> query = entityManager.createQuery(hqlQuery, User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        hqlQuery = "SELECT u FROM User u WHERE u.email = :email";
        TypedQuery<User> query = entityManager.createQuery(hqlQuery, User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
