package com.rivaldy.witchsaga.dto;

import lombok.Data;

@Data
public class StoryResponse {

    private Object given;
    private Object answer;

    public StoryResponse(Object given, Object answer) {
        this.given = given;
        this.answer = answer;
    }
}
