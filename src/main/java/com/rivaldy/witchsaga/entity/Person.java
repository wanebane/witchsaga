package com.rivaldy.witchsaga.entity;

import com.rivaldy.witchsaga.dto.PersonRequest;
import lombok.Data;

@Data
public class Person {

    private int age;
    private int year;
    private int numberOfDeaths;

    public Person(int age, int year) {
        this.age = age;
        this.year = year;
    }

    public Person(PersonRequest request){
        this.age = request.getAgeOfDeath();;
        this.year = request.getYearOfDeath();
    }
}
