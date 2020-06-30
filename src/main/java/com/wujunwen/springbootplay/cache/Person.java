package com.wujunwen.springbootplay.cache;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    @Autowired
    PersonDao personDao;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer savePerson(Person input) {
        return personDao.savePerson(input);
    }

    public Person getPersonById(Integer id) {
       return personDao.getPersonById(id);
    }

}
