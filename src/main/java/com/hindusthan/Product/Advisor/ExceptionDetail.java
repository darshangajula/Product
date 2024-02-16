package com.hindusthan.Product.Advisor;

import java.util.Date;

public class ExceptionDetail
{
    private Date timeStamp;
    private String message;
    private String details;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public ExceptionDetail(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
