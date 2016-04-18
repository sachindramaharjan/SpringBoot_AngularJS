package com.sachindramaharjan.catalogue.core.daoImpl;

import com.sachindramaharjan.catalogue.core.dao.GenericDaoInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
@Repository
public class GenericDaoImpl<T> implements GenericDaoInterface {

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
    public Object save(Object obj) {
        entityManager.persist(obj);
        entityManager.flush();
        return obj;
    }

    @Override
    public Object update(Object obj) {
        return entityManager.merge(obj);
    }

    @Override
    public Boolean delete(Object obj) {

        try {
            entityManager.remove(obj);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public Object find(Object obj) {
        return entityManager.find(type, obj);
    }
}
