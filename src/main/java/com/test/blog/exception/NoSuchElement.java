package com.test.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoSuchElement extends NoSuchElementException {
}
