package org.roopesh.restutils;

import java.time.Instant;


public class BaseResponse<T> {
    /*created immutable objects*/
    private final boolean success;
    private final String message;
    private final T data;
    private final String traceId;
    private final ErrorDetail errors;
    private final Instant timestamp;

    private BaseResponse(BaseResponseBuilder<T> builder) {
        this.success = builder.success;
        this.message = builder.message;
        this.data = builder.data;
        this.timestamp = builder.timestamp;
        this.traceId = builder.traceId;
        this.errors = builder.errors;
    }

    private boolean isSuccess() {
        return success;
    }

    private String getMessage() {
        return message;
    }


    private T getData() {
        return data;
    }


    private String getTraceId() {
        return traceId;
    }


    private Instant getTimestamp() {
        return timestamp;
    }


    private ErrorDetail getErrors() {
        return errors;
    }

    private static <T> BaseResponseBuilder<T> builder(){
        return new BaseResponseBuilder<>();
    }

    public static  <T>BaseResponse<T> success(T data){
        return BaseResponse.builder().
                     setMessage("Response is success")
                  .setSuccess(true).setData(data).build();
    }

    public static <T>BaseResponse<T> failure(ErrorDetail errors,String traceId){
        return BaseResponse.builder().
                setSuccess(false).
                setMessage("Please check the error details")
                .setErrors(errors)
                .setTraceId(traceId)
                .setTimestamp(Instant.now())
                .build();
    }

    private static class BaseResponseBuilder<T>{
        /*created temporary mutable objects to assign */
        private  boolean success;
        private  String message;
        private  T data;
        private  String traceId;
        private  ErrorDetail errors;
        private  Instant timestamp;


        private BaseResponseBuilder<T> setSuccess(boolean success) {
            this.success = success;
            return this;
        }

        private BaseResponseBuilder<T> setMessage(String message) {
            this.message = message;
            return this;
        }

        private BaseResponseBuilder<T> setData(T data) {
            this.data = data;
            return this;
        }

        private BaseResponseBuilder<T> setTraceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        private BaseResponseBuilder<T> setErrors(ErrorDetail errors) {
            this.errors = errors;
            return this;
        }

        private BaseResponseBuilder<T> setTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        private  <T> BaseResponse<T> build(){
             return new BaseResponse(this);
        }
    }

}
