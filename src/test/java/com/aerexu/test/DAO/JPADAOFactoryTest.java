package com.aerexu.test.DAO;

import com.aerexu.test.DAO.entity.Gender;
import com.aerexu.test.DAO.entity.PersonEntity;
import com.aerexu.test.DAO.util.JPAUtil;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public class JPADAOFactoryTest {
    EntityManagerFactory factory;
    EntityManager manager;

    @Before
    public void before() {
        factory = Persistence.createEntityManagerFactory("hibernate");
        manager = factory.createEntityManager();
        JPAUtil.setEntityManager(manager);
    }

    @Test
    public void testJPADAOFactory(){
        manager.getTransaction().begin();
        PersonEntity personEntity1 = new PersonEntity();
        personEntity1.setAge(10).setName("Tester A").setGender(Gender.Male);
        PersonDAO personDAO = JPADAOFactory.getInstance().getPersonDAO();
        personDAO.saveEntity(personEntity1);
        PersonEntity personEntity2 = personDAO.readEntity(personEntity1.getId(),false);
        personDAO.deleteEntity(personEntity1);
        manager.getTransaction().commit();
        System.out.println("end");
    }
}