package com.geektrust.coursescheduling.exceptions;

public class InputDataErrorException extends RuntimeException {
    public InputDataErrorException() {
        super("INPUT_DATA_ERROR");
    }
}
