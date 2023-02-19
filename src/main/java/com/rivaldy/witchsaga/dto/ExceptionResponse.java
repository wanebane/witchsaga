package com.rivaldy.witchsaga.dto;

import lombok.Data;

@Data
public class ExceptionResponse {

    private boolean success;
    private String message;
    private Object errorReason;

    public ExceptionResponse(boolean success, String message, Object errorReason) {
        this.success = success;
        this.message = message;
        this.errorReason = errorReason;
    }
}
