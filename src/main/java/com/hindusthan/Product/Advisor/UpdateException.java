package com.hindusthan.Product.Advisor;

public class UpdateException extends Exception {
    public UpdateException(String responseName) {
        this.responseName = responseName;
    }

    private String responseName;

    public String getResponseName() {
        return responseName;
    }
}
