package com.test.spring.boot.exception;


import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.test.spring.boot.enums.ErrorType;

@Component
public abstract class SystemException extends Exception implements Serializable {

  private static final long serialVersionUID = 3327217472962035232L;

  
  private ErrorType errorType;


  public SystemException(ErrorType type, Throwable t, String msg) {
    super(msg, t);
    this.errorType = type;
  }
 
  public SystemException(ErrorType type, String msg) {
    super(msg);
    this.errorType = type;
  }


  public SystemException(ErrorType type) {
    super(type.name() + ": " + type.description());
    this.errorType = type;
  }

  public SystemException(String msg) {
    super(msg);
  }
  
  public SystemException() {
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
