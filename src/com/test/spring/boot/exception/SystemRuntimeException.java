package com.test.spring.boot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.spring.boot.enums.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SystemRuntimeException extends RuntimeException {

  private static final long serialVersionUID = -5228947246289048733L;


  private ErrorType errorType;

  
  public SystemRuntimeException(ErrorType msg, Throwable t) {

    super(msg.name() + ": " + msg.description(), t);
    this.errorType = msg;
  }

  
  public SystemRuntimeException(ErrorType msg) {

    super(msg.name() + ": " + msg.description());
    this.errorType = msg;
  }

  public SystemRuntimeException() {
    this(ErrorType.SYS0001);
  }


  private ErrorType obtainErrorType() {
    if (errorType == null) {
      return ErrorType.SYS0001;
    }
    return errorType;

  }

 
  public ErrorType getErrorType() {
    return obtainErrorType();
  }


  public String getErrorCode() {
    return obtainErrorType().name();
  }

  public String getErrorMsg() {
    return obtainErrorType().description();
  }
}
