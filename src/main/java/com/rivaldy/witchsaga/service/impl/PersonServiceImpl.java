package com.rivaldy.witchsaga.service.impl;

import com.rivaldy.witchsaga.dto.PersonRequest;
import com.rivaldy.witchsaga.entity.Person;
import com.rivaldy.witchsaga.service.IPerson;
import com.rivaldy.witchsaga.story.CalculateKilled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPerson {

    @Override
    public List<Person> addPerson(List<PersonRequest> requests) {
        List<Person> persons = new ArrayList<>();
        requests.forEach(r -> {
            Person person = new Person(r);
            person.setNumberOfDeaths(numberOfDeath(person));
            persons.add(person);
        });

        return persons;
    }

    @Override
    public int numberOfDeath(Person person){
        return new CalculateKilled().setNumberOfDeath(person);
    }
}
