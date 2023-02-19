package com.rivaldy.witchsaga.service.impl;

import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.dto.PersonRequest;
import com.rivaldy.witchsaga.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static com.rivaldy.witchsaga.constant.Message.RESPONSE_TEST;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PersonServiceImplTest {

    private PersonServiceImpl service;
    private List<PersonRequest> requests;

    @BeforeEach
    void setUp(){
        service = new PersonServiceImpl();

        requests = new ArrayList<>();
        requests.add(new PersonRequest(10, 13));
        requests.add(new PersonRequest(13, 17));
    }

    @Test
    @DisplayName("Add Person than set number of death each time")
    void addPerson_returnListOfPersonWithNumberOfDeath(){
        requests.add(new PersonRequest(15, 19));

        int expectedDeath = 0;
        List<Person> actualPersons = service.addPerson(requests);
        actualPersons.stream().forEach(ap -> {
            assertNotEquals(expectedDeath, ap.getNumberOfDeaths());
            log.info(RESPONSE_TEST, expectedDeath, ap.getNumberOfDeaths(), Thread.currentThread().getStackTrace()[1].getMethodName());
        });

        assertEquals(3, actualPersons.size());
        log.info(RESPONSE_TEST, 3, actualPersons.size(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @DisplayName("Will return -1 if person age > year")
    void numberOfDeath_returnNegative1(){
        Person person = new Person(13, 10);
        int expectedNumber = -1;
        int actualDeath = service.numberOfDeath(person);
        assertEquals(expectedNumber, actualDeath);
        log.info(RESPONSE_TEST, expectedNumber, actualDeath, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @DisplayName("Will return 0 if person age == year")
    void numberOfDeath_returnZero(){
        Person person = new Person(10, 10);
        int expectedNumber = 0;
        int actualDeath = service.numberOfDeath(person);
        assertEquals(expectedNumber, actualDeath);
        log.info(RESPONSE_TEST, expectedNumber, actualDeath, Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}