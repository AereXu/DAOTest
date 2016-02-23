package com.aerexu.test.DAO;

import com.aerexu.test.DAO.entity.PersonEntity;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public class PersionDAOJPA extends GenericJPADAO<PersonEntity, Long> implements PersonDAO {

    public PersonEntity findByAge(Integer age) {
        return null;
    }
}
