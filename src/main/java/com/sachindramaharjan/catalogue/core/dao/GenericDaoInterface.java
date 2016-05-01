package com.sachindramaharjan.catalogue.core.dao;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
public interface GenericDaoInterface<T> {

    <T> T save(T obj);
    <T> T update(T obj);
    boolean delete(T obj);
    <T> T find(T obj);

}
