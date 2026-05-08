package org.roopesh.restutils;

public class ErrorDetail {
    private final String errorMessage;
    private final String code;
    private final String errorField;

    public ErrorDetail(String errorMessage, String code, String errorField) {
        this.errorMessage = errorMessage;
        this.code = code;
        this.errorField = errorField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getCode() {
        return code;
    }

    public String getErrorField() {
        return errorField;
    }
}
