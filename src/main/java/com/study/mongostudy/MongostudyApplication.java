package com.study.mongostudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@EnableMongoRepositories
@ComponentScan("com.study")
@SpringBootApplication
public class MongostudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongostudyApplication.class, args);
    }

}
