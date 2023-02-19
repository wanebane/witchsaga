package com.rivaldy.witchsaga.story;

import com.rivaldy.witchsaga.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.rivaldy.witchsaga.constant.Message.RESPONSE_TEST;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AnswerStoryTest {

    private AnswerStory logAnswer;
    private CalculateKilled calc;
    private List<Person> personList;

    @BeforeEach
    void setUp(){
        logAnswer = new AnswerStory();
        calc = new CalculateKilled();
        personList = new ArrayList<>();

        Person person1 = new Person(10,13);
        person1.setNumberOfDeaths(calc.setNumberOfDeath(person1));
        personList.add(person1);

        Person person2 = new Person(13,17);
        person2.setNumberOfDeaths(calc.setNumberOfDeath(person2));
        personList.add(person2);
    }

    @Test
    @DisplayName("Get Log Answer")
    void getLog_returnLogPersonList(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        List<String> expectedLog = new ArrayList<>();
        expectedLog.add("Person 1 born on Year = 13 - 10 = 3, number of people killed on year 3 is 4.");
        expectedLog.add("Person 2 born on Year = 17 - 13 = 4, number of people killed on year 4 is 7.");
        expectedLog.add("So the average is ( 4 + 7 )/2 = 5.5");

        List<String> actualLog = logAnswer.getLog(personList);

        IntStream.range(0, actualLog.size()).forEach(i -> {
            assertEquals(expectedLog.get(i), actualLog.get(i));
            log.info(RESPONSE_TEST, expectedLog.get(i), actualLog.get(i), method);
        });
    }

    @Test
    @DisplayName("Will return log answer for 2 person")
    void getLogAveragePerson_returnLog(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        String actualLog = logAnswer.getLogAveragePerson(personList);
        String expectedLog = "So the average is ( 4 + 7 )/2 = 5.5";

        assertEquals(expectedLog, actualLog);
        log.info(RESPONSE_TEST, expectedLog, actualLog, method);
    }

    @Test
    @DisplayName("Will return log answer when add new person")
    void getLogAveragePerson_returnLogWhenAddNewPerson(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        Person person = new Person(20, 25);
        person.setNumberOfDeaths(calc.setNumberOfDeath(person));
        personList.add(person);

        String actualLog = logAnswer.getLogAveragePerson(personList);
        String expectedLog = "So the average is ( 4 + 7 + 12 )/3 = 7.66";

        assertEquals(expectedLog, actualLog);
        log.info(RESPONSE_TEST, expectedLog, actualLog, method);
    }

    @Test
    @DisplayName("Will return log answer when add new person with invalid data")
    void getLogAveragePerson_returnLogWhenAddNewPersonWithInvalidData(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        Person person = new Person(20, 17);
        person.setNumberOfDeaths(calc.setNumberOfDeath(person));
        personList.add(person);

        String actualLog = logAnswer.getLogAveragePerson(personList);
        String expectedLog = "So the average is ( 4 + 7 + -1 )/3 = 3.33";

        assertEquals(expectedLog, actualLog);
        log.info(RESPONSE_TEST, expectedLog, actualLog, method);
    }
}