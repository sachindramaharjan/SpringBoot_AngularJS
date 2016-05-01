package com.sachindramaharjan.catalogue.core.daoImpl;

import com.sachindramaharjan.catalogue.core.dao.GenericDaoInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
@Repository
public class GenericDaoImpl<T> implements GenericDaoInterface<T> {

    protected EntityManager entityManager;
    private Class<T> type;

    public GenericDaoImpl(){}

    public GenericDaoImpl(Class<T> type){
        this.type = type;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T> T save(T obj){
        entityManager.persist(obj);
        entityManager.flush();
        return obj;
    }

    @Override
    public <T> T update(T obj) {
        return entityManager.merge(obj);
    }

    @Override
    public boolean delete(Object obj) {

        try {
            entityManager.remove(obj);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public <T> T find(T obj) {
        return entityManager.find((Class<T>) type, obj);
    }

}
