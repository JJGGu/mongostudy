package com.study.dao.Impl;

import com.mongodb.client.MongoCollection;
import com.study.dao.PersonDao;
import com.study.pojo.Person;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: mongostudy
 * @description:
 * @author: JJGGu
 * @create: 2020-06-21 20:38
 **/
@Component
public class PersonDaoImpl implements PersonDao {

    private static Logger logger = Logger.getLogger(PersonDaoImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertOne(Person person) {
        mongoTemplate.insert(person);
        logger.info(person);
    }

    @Override
    public void deleteById(ObjectId id) {
         mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Person.class);
         logger.info("deletebyid---------------");
    }

    @Override
    public void deleteByName(String name) {
        mongoTemplate.remove(new Query(Criteria.where("name").is(name)), Person.class);
        logger.info("deleteByName--------------");
    }

    @Override
    public void updateOne(Person person) {
        Query query = new Query(Criteria.where("id").is(person.getId()).orOperator(Criteria.where("name").is(person.getName())));
        Update update = new Update();
        update.set("name", person.getName() + "af");
        update.set("age", person.getAge() + 10);

        mongoTemplate.updateFirst(query,update, Person.class);
        logger.info("update------------------");
    }

    @Override
    public Person findById(ObjectId id) {
        return mongoTemplate.findById(id, Person.class);
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> personList = mongoTemplate.find(new Query(Criteria.where("name").is(name)), Person.class);
//                mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), Person.class);
        logger.info(personList);
        return personList;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people =  mongoTemplate.findAll(Person.class);
        logger.info(people);
        return people;
    }

    public void select(){
        MongoCollection<Document> collection = mongoTemplate.getCollection("person");


    }
}
