package com.backend.api.models.exceptions;

public class TmdbServerOffException extends Exception{
    public String message = "API de terceiros Offline, Tente novamente mais tarde.";
    public TmdbServerOffException(String message){
        super(message);
    }
}