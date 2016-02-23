package com.aerexu.test.DAO.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        JPAUtil.entityManagerFactory = entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void setEntityManager(EntityManager entityManager) {
        JPAUtil.entityManager = entityManager;
    }
}
