package com.study.dao;


import com.study.pojo.Person;
import org.bson.types.ObjectId;

import java.util.List;

public interface PersonDao {
    //curd
    void insertOne(Person person);
    void deleteById(ObjectId id);
    void deleteByName(String name);
    void updateOne(Person person);
    Person findById(ObjectId id);
    List<Person> findByName(String name);
    List<Person> findAll();

}
