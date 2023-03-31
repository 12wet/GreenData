package com.greendata.responses;

import com.greendata.responses.base.Response;

public class ResponseMessage implements Response {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}