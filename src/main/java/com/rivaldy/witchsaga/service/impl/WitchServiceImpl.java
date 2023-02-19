package com.rivaldy.witchsaga.service.impl;

import com.rivaldy.witchsaga.dto.StoryResponse;
import com.rivaldy.witchsaga.dto.VillagerRequest;
import com.rivaldy.witchsaga.entity.Person;
import com.rivaldy.witchsaga.service.IPerson;
import com.rivaldy.witchsaga.service.IWitch;
import com.rivaldy.witchsaga.story.AnswerStory;
import com.rivaldy.witchsaga.story.GivenStory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WitchServiceImpl implements IWitch {

    private final GivenStory givenStory;
    private final AnswerStory answerStory;
    private final IPerson personService;

    @Override
    public StoryResponse getStory(VillagerRequest request) {
        List<String> givenStories = givenStory.getLog(request.getPersons());
        List<Person> personList = personService.addPerson(request.getPersons());
        List<String> answerStories = answerStory.getLog(personList);
        return new StoryResponse(givenStories, answerStories);
    }
}
