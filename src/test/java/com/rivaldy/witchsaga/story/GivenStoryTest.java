package com.rivaldy.witchsaga.story;

import com.rivaldy.witchsaga.dto.PersonRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.rivaldy.witchsaga.constant.Message.RESPONSE_TEST;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class GivenStoryTest {

    private GivenStory logStory;
    private List<PersonRequest> requests;

    @BeforeEach
    void setUp(){
        logStory = new GivenStory();
        requests = new ArrayList<>();
        requests.add(new PersonRequest(10, 13));
        requests.add(new PersonRequest(13, 17));
    }

    @Test
    @DisplayName("Get Log Given Story Will Return 2 Log String for Given Story")
    void getLog_returnSizeLog2Person(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        List<String> expectedLog = new ArrayList<>();
        expectedLog.add("Person 1 : Age of Death = 10, Year of Death = 13");
        expectedLog.add("Person 2 : Age of Death = 13, Year of Death = 17");

        List<String> actualLog = logStory.getLog(requests);

        IntStream.range(0, actualLog.size()).forEach(i -> {
            assertEquals(expectedLog.get(i), actualLog.get(i));
            log.info(RESPONSE_TEST, expectedLog.get(i), actualLog.get(i), method);
        });
    }

    @Test
    @DisplayName("Get Log Given Story Will Return 2 Log String for Given Story")
    void getLog_returnLogWithAddNewPerson(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        List<String> expectedLog = new ArrayList<>();
        expectedLog.add("Person 1 : Age of Death = 10, Year of Death = 13");
        expectedLog.add("Person 2 : Age of Death = 13, Year of Death = 17");
        expectedLog.add("Person 3 : Age of Death = 16, Year of Death = 18");

        requests.add(new PersonRequest(16, 18));
        List<String> actualLog = logStory.getLog(requests);

        IntStream.range(0, actualLog.size()).forEach(i -> {
            assertEquals(expectedLog.get(i), actualLog.get(i));
            log.info(RESPONSE_TEST, expectedLog.get(i), actualLog.get(i), method);
        });
    }
}