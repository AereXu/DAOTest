package com.aerexu.test.DAO.entity;

/**
 * Created by epxpxpx on 2/23/2016.
 */
public enum Gender {
    Male("Male", 0),
    Female("Female", 1),
    Other("Other", 2);

    private String name;
    private Integer value;

    Gender(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
