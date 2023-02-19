package com.rivaldy.witchsaga.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalPersonIsNotMatchException extends RuntimeException{

    private final String message;
    public TotalPersonIsNotMatchException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace){
        super(message, cause, enableSuppresion, writableStackTrace);
        this.message = message;
    }
}
