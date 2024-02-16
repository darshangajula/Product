package com.hindusthan.Product.Advisor;

public class SaveException extends Exception{
    private String responseName;

    public String getResponseName() {
        return responseName;
    }

    public SaveException(String responseName) {
        this.responseName = responseName;
    }
}
