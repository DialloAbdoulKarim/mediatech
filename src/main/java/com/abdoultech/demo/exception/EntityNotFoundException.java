package com.abdoultech.demo.exception;


public class EntityNotFoundException extends RuntimeException{


    public EntityNotFoundException(){

    }

    public EntityNotFoundException(String message){
        super(message);
    }
}
