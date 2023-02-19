package com.rivaldy.witchsaga.service.impl;

import com.rivaldy.witchsaga.dto.PersonRequest;
import com.rivaldy.witchsaga.dto.StoryResponse;
import com.rivaldy.witchsaga.dto.VillagerRequest;
import com.rivaldy.witchsaga.entity.Person;
import com.rivaldy.witchsaga.service.IPerson;
import com.rivaldy.witchsaga.story.AnswerStory;
import com.rivaldy.witchsaga.story.GivenStory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@Slf4j
@ExtendWith(MockitoExtension.class)
class WitchServiceImplTest {

    @Mock
    private WitchServiceImpl service;
    @Mock
    private IPerson personService;

    @Mock
    private GivenStory givenStory;

    @Mock
    private AnswerStory answerStory;

    private List<PersonRequest> personRequest;
    private List<String> givenStories;
    private List<String> answerStories;

    @BeforeEach
    void setUp(){

        personRequest = new ArrayList<>();
        personRequest.add(new PersonRequest(10, 13));
        personRequest.add(new PersonRequest(13, 17));

        givenStories = new ArrayList<>();
        givenStories = givenStory.getLog(personRequest);

        List<Person> persons = personService.addPerson(personRequest);
        answerStories = new ArrayList<>();
        answerStories = answerStory.getLog(persons);
    }

    @Test
    void getStory_returnLogStory(){

        VillagerRequest request = new VillagerRequest(2, personRequest);
        WitchServiceImpl witchSvc = mock(WitchServiceImpl.class);
        StoryResponse otherResponse = mock(StoryResponse.class);
        lenient().when(witchSvc.getStory(request))
                .thenReturn(otherResponse);

        StoryResponse storyResponse = new StoryResponse(givenStories, answerStories);
        givenStories.stream().forEach(System.out::println);
        answerStories.stream().forEach(System.out::println);
    }
}