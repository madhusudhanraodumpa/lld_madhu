package com.design.parkinglot.exception;

public class NoAvailableSlotException extends Exception{
    public NoAvailableSlotException(){

    }
    public NoAvailableSlotException(String message) {
        super(message);
    }
}
