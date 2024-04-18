package com.backend.api.models;

public class ErrorMessage {
    public Boolean success = false;
    public String message;

    public ErrorMessage(){ }

    public ErrorMessage(String message){
        this.message = message;
    }

    public ErrorMessage(Boolean success, String message){
        this.success = success;
        this.message = message;
    }
}