package com.hindusthan.Product.Advisor;

public class DeleteException extends Exception{
private String responseName;

    public String getResponseName() {
        return responseName;
    }

    public DeleteException(String responseName) {
        this.responseName = responseName;
    }
}
