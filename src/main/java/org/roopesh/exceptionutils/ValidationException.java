package org.roopesh.exceptionutils;

import org.roopesh.restutils.ErrorDetail;

import java.util.List;

public class ValidationException extends RuntimeException{

    private List<ErrorDetail> errorDetailList;

    public ValidationException(String message, List<ErrorDetail> errorDetailList){
        super(message);
        this.errorDetailList = errorDetailList;
    }

    public List<ErrorDetail> getErrorDetailList() {
        return errorDetailList;
    }
}
