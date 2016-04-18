package com.sachindramaharjan.catalogue.core.dao;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
public interface GenericDaoInterface<T> {

    public T save(T obj);
    public T update(T obj);
    public Boolean delete(T obj);
    public T find(T obj);

}
