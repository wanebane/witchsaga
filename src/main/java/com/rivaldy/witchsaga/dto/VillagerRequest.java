package com.rivaldy.witchsaga.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class VillagerRequest {

    @ApiModelProperty(value = "Total Person of The Villager", required = true)
    @Min(value = 1, message = "Must set the value totalPerson more than 1")
    private int totalPerson;

    @ApiModelProperty(value = "List Person of the villager", required = true)
    @NotEmpty(message = "persons must not be empty")
    private List<PersonRequest> persons;

    public VillagerRequest(int totalPerson, List<PersonRequest> persons) {
        this.totalPerson = totalPerson;
        this.persons = persons;
    }
}
