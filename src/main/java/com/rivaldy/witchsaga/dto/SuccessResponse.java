package com.rivaldy.witchsaga.dto;

import lombok.Data;

@Data
public class ApiResponse {

    private boolean success;

    private Object data;

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
}
