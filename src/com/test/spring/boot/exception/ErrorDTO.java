package com.test.spring.boot.exception;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String uri;
    private final String code;
    private final String description;

    public ErrorDTO(String message) {
        this(null, message, null);
    }

    public ErrorDTO(String uri, String code, String description) {
        this.uri = uri;
        this.code = code;
        this.description = description;
    }

    public String getUri() {
       return uri;
    }

    public String getCode() {
       return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" + "uri=" + uri + ", code=" + code + ", description=" + description + '}';
    }
 }