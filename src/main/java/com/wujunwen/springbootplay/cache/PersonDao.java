package com.wujunwen.springbootplay.cache;

import org.springframework.stereotype.Component;


@Component
public class PersonDao {


    @CachePut
    public Integer savePerson(Person input) {
       return savePersontoDB(input) ;
    }

    @CacheGet
    public Person getPersonById(Integer id) {
        return getPersonFromDb(id);

    }

    //模拟存储和读取的方法
    public Person getPersonFromDb(Integer id){
        return new Person();
    }

    public Integer savePersontoDB(Person person) {
        return new Person().getId();
    }
}
