package com.rivaldy.witchsaga.story;

import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CalculateKilledTest {

    private List<Person> persons;

    private CalculateKilled calc = new CalculateKilled();
    private final String RESPONSE = Message.RESPONSE_TEST;

    @BeforeEach
    void setUp() {
        persons = new ArrayList<>();

        Person person1 = new Person(10, 12);
        person1.setNumberOfDeaths(calc.setNumberOfDeath(person1));
        persons.add(person1);

        Person person2 = new Person(13, 17);
        person2.setNumberOfDeaths(calc.setNumberOfDeath(person2));
        persons.add(person2);

    }

    @Test
    @DisplayName("Get Year Killed is not equal to 0")
    void getYearKilled_mustNotEqualThanExpected(){
        Person person = new Person(13, 10);
        int actual = calc.getYearKilled(person);
        int expected = 0;
        assertNotEquals(expected, actual);
        log.info(RESPONSE, expected, actual, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @DisplayName("Get Person will return -1 when age > year")
    void getPersonKilled_mustReturnNegative1(){
        Person person = new Person(13, 10);
        int actual = calc.getPersonKilled(calc.getYearKilled(person));
        assertEquals(-1, actual);
        log.info(RESPONSE, -1, actual, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @DisplayName("Get Person will return 0 when age == year")
    void getPersonKilled_mustReturnZero(){
        Person person = new Person(13, 13);
        int actual = calc.getPersonKilled(calc.getYearKilled(person));
        assertEquals(0, actual);
        log.info(RESPONSE, 0, actual, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @DisplayName("Average death must return 4.5")
    void getAverageDeath_mustReturn4point5(){
        double expectedResult = 4.5;
        double actual = calc.getAverageDeath(persons);
        assertEquals(expectedResult, actual);
        log.info(RESPONSE, expectedResult, actual, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    @DisplayName("Average death must return 7 when add new person")
    void getAverageDeath_whenAddNewPerson(){
        double expectedResult = 7.0;

        Person person = new Person(13, 18);
        person.setNumberOfDeaths(calc.setNumberOfDeath(person));
        persons.add(person);

        double actual = calc.getAverageDeath(persons);

        assertEquals(expectedResult, actual);
        log.info(RESPONSE, expectedResult, actual, Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}