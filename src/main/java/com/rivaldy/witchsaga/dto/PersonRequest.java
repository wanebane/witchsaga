package com.rivaldy.witchsaga.dto;

import lombok.Data;

@Data
public class PersonRequest {

    private int ageOfDeath;
    private int yearOfDeath;

    public PersonRequest(int ageOfDeath, int yearOfDeath) {
        this.ageOfDeath = ageOfDeath;
        this.yearOfDeath = yearOfDeath;
    }
}
