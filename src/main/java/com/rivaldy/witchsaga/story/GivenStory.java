package com.rivaldy.witchsaga.story;

import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.dto.PersonRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GivenStory {

    public List<String> getLog(List<PersonRequest> requests){
        List<String> logs = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);
        requests.forEach(r ->{
            String log = String.format(Message.GIV_PERSON, counter.incrementAndGet(), r.getAgeOfDeath(), r.getYearOfDeath());
            logs.add(log);
        });
        return logs;
    }
}
