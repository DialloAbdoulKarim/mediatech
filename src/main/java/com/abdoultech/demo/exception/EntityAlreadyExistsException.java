package com.abdoultech.demo.exception;


public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(){

    }

    public EntityAlreadyExistsException(String messsage) {
        super(messsage);
    }
}
