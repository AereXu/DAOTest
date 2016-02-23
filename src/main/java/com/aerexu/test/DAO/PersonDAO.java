package com.aerexu.test.DAO;

import com.aerexu.test.DAO.entity.PersonEntity;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public interface PersonDAO extends GenericDAO<PersonEntity, Long> {
    PersonEntity findByAge(Integer age);
}
