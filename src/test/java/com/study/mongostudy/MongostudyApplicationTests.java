package com.study.mongostudy;

import com.study.dao.PersonDao;
import com.study.pojo.Person;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;
import java.time.Period;
import java.util.List;

@EnableMongoRepositories
@ComponentScan("com.study")
@SpringBootTest
class MongostudyApplicationTests {

    @Resource
    private PersonDao personDao;
    @Test
    void contextLoads() {
    }

    @Test
    void test01(){
        List<Person> people = personDao.findAll();
        people.forEach(System.out::println);
    }

    @Test
    void test02(){
        List<Person> people = personDao.findByName("xuhaoran");

        people.forEach(System.out::println);

    }

    @Test
    void test03(){
        personDao.insertOne(new Person("Lily", 22));
    }

    @Test
    void test04(){
        personDao.updateOne(new Person("xuhaoran", 20));

    }


}
