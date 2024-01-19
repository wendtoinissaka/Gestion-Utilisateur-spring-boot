package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wendtoin Issaka
 */
@ControllerAdvice
public class UserNotFoundAdvice {
    @ResponseBody
     @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> ExceptionHandler(UserNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error Message ", exception.getMessage());
        return errorMap;
    }
}