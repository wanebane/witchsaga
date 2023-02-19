package com.rivaldy.witchsaga.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class VillagerRequest {

    @Min(value = 1, message = "Must set the value totalPerson more than 1")
    private int totalPerson;

    @NotEmpty(message = "persons must not be empty")
    private List<PersonRequest> persons;

    public VillagerRequest(int totalPerson, List<PersonRequest> persons) {
        this.totalPerson = totalPerson;
        this.persons = persons;
    }
}
