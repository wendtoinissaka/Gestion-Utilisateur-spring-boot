package com.example.demo.exception;

/**
 * Created by Wendtoin Issaka
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("User with id " + id + " not found");
    }
}



