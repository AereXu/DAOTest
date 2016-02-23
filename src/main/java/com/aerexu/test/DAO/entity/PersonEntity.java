package com.aerexu.test.DAO.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by epxpxpx on 2/23/2016.
 */
@Entity
@Table(name = "T_PERSON")
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "SEQ_PERSON_ID", sequenceName = "SEQ_PERSON_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSON_ID")
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Gender gender;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PersonEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public PersonEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Date getBirth() {
        return birth;
    }

    public PersonEntity setBirth(Date birth) {
        this.birth = birth;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public PersonEntity setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
