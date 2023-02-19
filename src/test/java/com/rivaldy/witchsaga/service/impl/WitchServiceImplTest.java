package com.rivaldy.witchsaga.service.impl;

import com.rivaldy.witchsaga.dto.PersonRequest;
import com.rivaldy.witchsaga.service.IPerson;
import com.rivaldy.witchsaga.story.AnswerStory;
import com.rivaldy.witchsaga.story.GivenStory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class WitchServiceImplTest {

    private WitchServiceImpl service;
    private List<PersonRequest> requests;
    @MockBean
    private IPerson personService;

    @BeforeEach
    void setUp(){
        service = new WitchServiceImpl(new GivenStory(), new AnswerStory(), personService);

        requests = new ArrayList<>();
        requests.add(new PersonRequest(10, 13));
        requests.add(new PersonRequest(13, 17));
    }
}