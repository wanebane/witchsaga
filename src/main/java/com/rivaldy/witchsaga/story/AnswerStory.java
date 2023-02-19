package com.rivaldy.witchsaga.story;

import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AnswerStory {

    public List<String> getLog(List<Person> personList){
        List<String> logs = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);
        CalculateKilled calc = new CalculateKilled();
        personList.forEach(p -> {
            String log = String.format(Message.ANS_PERSON_NUMBER_OF_KILLED, counter.incrementAndGet(),
                    p.getYear(), p.getAge(), calc.getYearKilled(p), calc.getYearKilled(p), p.getNumberOfDeaths());
            logs.add(log);
        });
        logs.add(getLogAveragePerson(personList));
        return logs;
    }

    public String getLogAveragePerson(List<Person> personList){
        String strSumOfDeaths = personList.stream()
                .map(p -> String.valueOf(p.getNumberOfDeaths()))
                .collect(Collectors.joining(" + "));
        return String.format(Message.ANS_AVERAGE_NUMBER_OF_KILLED, strSumOfDeaths
                , personList.size(), new CalculateKilled().getAverageDeath(personList));
    }
}
