package com.emre.exception;

import lombok.Getter;

@Getter
public class EmployeeException extends RuntimeException {

    private final ErrorType errorType;

    public EmployeeException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    public EmployeeException(ErrorType errorType, String message) {
        super(message);
        this.errorType=errorType;
    }
}
