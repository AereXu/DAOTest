package com.aerexu.test.DAO;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
        implements GenericDAO<T, ID> {

    private Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void setSession(Session s) {
        this.session = s;
    }

    protected Session getSession() {
        if (session == null) {
            throw new IllegalStateException("Session has not been set on DAO before usage");
        }
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }


    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByEntity(T entityInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(entityInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    /**
     * get lock information at http://stackoverflow.com/questions/21030740/hibernate-lockmodes-lockoptions
     *
     * @param id
     * @param lock
     * @return
     */
    @SuppressWarnings("unchecked")
    public T readEntity(ID id, boolean lock) {
        T entity = null;
        Object o;
        if (lock) {
            o = getSession().get(getPersistentClass(), id, LockOptions.UPGRADE);
        } else {
            o = getSession().get(getPersistentClass(), id);
        }
        if (o != null) {
            entity = (T) o;
        }
        return entity;
    }

    public T saveEntity(T entity) {
        getSession().save(entity);
        return entity;
    }

    public T storeEntity(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public T updateEntity(T entity){
        getSession().update(entity);
        return entity;
    }
    public void deleteEntity(T entity) {
        getSession().delete(entity);
    }

    public T refreshEntity(T entity){
        getSession().refresh(entity);
        return entity;
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

}