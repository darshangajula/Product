package com.hindusthan.Product.Advisor;

public class FindException extends Exception{
    private String responseHandler;

    public String getResponseHandler() {
        return responseHandler;
    }

    public FindException(String responseHandler) {
        this.responseHandler = responseHandler;
    }
}
