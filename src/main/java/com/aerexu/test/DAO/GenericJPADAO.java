package com.aerexu.test.DAO;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public abstract class GenericJPADAO <T, ID extends Serializable>
        implements GenericDAO<T, ID>  {

    private Class<T> persistentClass;
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public GenericJPADAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void setEntityManager(EntityManager m) {
        this.manager = m;
    }

    protected EntityManager getManager() {
        if (manager == null) {
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        }
        return manager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public List<T> findAll() {
        return null;
    }

    public List<T> findByEntity(T entityInstance) {
        return null;
    }

    // get more lock information at http://docs.oracle.com/javaee/7/api/javax/persistence/LockModeType.html
    @SuppressWarnings("unchecked")
    public T readEntity(ID id, boolean lock) {
        T entity;
        if (lock) {
            entity = getManager().find(getPersistentClass(), id, LockModeType.PESSIMISTIC_WRITE);
        }else {
            entity = getManager().find(getPersistentClass(), id);
        }
        return entity;
    }

    public T saveEntity(T entity) {
        getManager().persist(entity);
        return entity;
    }

    public T updateEntity(T entity) {
        getManager().merge(entity);
        return entity;
    }

    public T refreshEntity(T entity){
        getManager().refresh(entity);
        return entity;
    }

    public void deleteEntity(T entity) {

    }
}
