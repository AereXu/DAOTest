package com.aerexu.test.DAO;

public abstract class DAOFactory {

    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
//    public static final Class HIBERNATE = org.hibernate.ce.auction.dao.hibernate.HibernateDAOFactory.class;

    /**
     * Factory method for instantiation of concrete factories.
     */
    protected GenericJPADAO instantiateDAO(Class factory) {
        try {
            return (GenericJPADAO) factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create GenericJPADAO: " + factory);
        }
    }

    // Add your DAO interfaces here
//    public abstract ContentDAO getContentDAO();
    public abstract PersonDAO getPersonDAO();


}
