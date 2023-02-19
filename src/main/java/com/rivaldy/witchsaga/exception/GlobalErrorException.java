package com.rivaldy.witchsaga.exception;

import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.dto.ExceptionResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalErrorException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        false,
                        Message.ERR_DATA_BAD_REQUEST,
                        ex.getBindingResult().getFieldErrors().stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.toList())
                ));
    }

    @ExceptionHandler(TotalPersonIsNotMatchException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity handleTotalPersonIsNotMatch(TotalPersonIsNotMatchException ex){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(false, Message.ERR_TOTAL_IS_NOT_MATCH, ex.getMessage()));
    }
}
