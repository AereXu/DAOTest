package com.aerexu.test.DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    /**
     * get all entities in db
     * @return
     */
    List<T> findAll();

    /**
     * get all certain type of the passed entities
     * @param entityInstance
     * @return
     */
    List<T> findByEntity(T entityInstance);

    /**
     * read entity by id
     * @param id
     * @param lock
     * @return
     */
    T readEntity(ID id, boolean lock);

    T saveEntity(T entity);

    T updateEntity(T entity);

    T refreshEntity(T entity);

    void deleteEntity(T entity);

    public List<T> getNamedQueryResults(String namedQuery, Object... args);
}
