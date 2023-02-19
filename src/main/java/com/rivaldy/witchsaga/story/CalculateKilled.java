package com.rivaldy.witchsaga.story;

import com.rivaldy.witchsaga.entity.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculateKilled {

    public int getYearKilled(Person person) {
        return person.getYear() - person.getAge();
    }

    public int setNumberOfDeath(Person person){
        return getPersonKilled(getYearKilled(person));
    }

    public int getPersonKilled(int ageYear){
        if(ageYear < 0){
            return -1;
        }
        if(ageYear == 0){
            return 0;
        }
        if(ageYear == 1){
            return 1;
        }
        return getPersonKilled(ageYear - 1) +
                getPersonKilled(ageYear - 2) + 1;
    }

    public double getAverageDeath(List<Person> personList){
        int totalNumberOfDeath = personList.stream().mapToInt(n -> n.getNumberOfDeaths()).sum();
        double avgDeath = (double) totalNumberOfDeath / personList.size();
        avgDeath = BigDecimal.valueOf(avgDeath).setScale(2, RoundingMode.FLOOR).doubleValue();
        return avgDeath;
    }
}
