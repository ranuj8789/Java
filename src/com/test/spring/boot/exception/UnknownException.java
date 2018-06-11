package com.test.spring.boot.exception;

import org.springframework.stereotype.Component;

import com.test.spring.boot.enums.ErrorType;

@Component
public class UnknownException extends SystemRuntimeException {

  private static final long serialVersionUID = -7431810328087316293L;

  private final static ErrorType ERROR_TYPE = ErrorType.UNKNOWN;

  public UnknownException() {
    super(ERROR_TYPE);
  }
}
