package com.test.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoSearchDataException extends IllegalArgumentException{
    public NoSearchDataException(){
    }

    public NoSearchDataException(String msg){
        System.err.println(msg);
    }

}
