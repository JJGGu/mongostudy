package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: mongostudy
 * @description:
 * @author: JJGGu
 * @create: 2020-06-21 20:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "person")
public class Person {
    @Id
    private ObjectId id;
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
