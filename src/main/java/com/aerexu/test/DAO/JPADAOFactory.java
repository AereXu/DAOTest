package com.aerexu.test.DAO;

import com.aerexu.test.DAO.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public class JPADAOFactory extends DAOFactory {

    private static class Inner {
        private static JPADAOFactory instance = new JPADAOFactory();
        private Inner() {
        }
    }

    public static JPADAOFactory getInstance() {
        return Inner.instance;
    }

    @Override
    protected GenericJPADAO instantiateDAO(Class daoClass) {
        try {
            GenericJPADAO dao = (GenericJPADAO) daoClass.newInstance();
            dao.setEntityManager(getCurrentEntityManager());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

    protected EntityManager getCurrentEntityManager() {
        return JPAUtil.getEntityManager();
    }

    @Override
    public PersonDAO getPersonDAO() {
        return (PersonDAO) instantiateDAO(PersionDAOJPA.class);
    }
}
