package com.rivaldy.witchsaga.service;

import com.rivaldy.witchsaga.dto.PersonRequest;
import com.rivaldy.witchsaga.entity.Person;

import java.util.List;

public interface IPerson {

    List<Person> addPerson(List<PersonRequest> requests);
    int numberOfDeath(Person person);
}
