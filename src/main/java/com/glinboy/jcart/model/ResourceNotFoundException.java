package com.glinboy.jcart.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7947367591161991194L;

	public ResourceNotFoundException(String exception) {
        super(exception);
    }

}