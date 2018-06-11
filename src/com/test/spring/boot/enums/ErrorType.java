package com.test.spring.boot.enums;


public enum ErrorType implements IntentStateWithDescription {

  // System
  SYS0001("System error."),
  SYS0002("Param is not acceptable."),
  SYS0003("You need use 'bearer' token."),


  // COMMONS
  SYS0100("%s error."),  

  // LOGIN
  LOG0001("User not exists."),
  LOG0002("Wrong password."),
  LOG0003("Disabled account."),
  LOG0004("Expired account."),
  LOG0005("Locked account."),
  LOG0006("Expired credentials."),
  LOG0007("Illegal token type."),

  // Unknown error.
  UNKNOWN("unknown error."),;

 
  private final String description;

 
  ErrorType(String description) {
    this.description = description;
  }

  @Override 
  public String description() {
    return this.description;
  }

  public static ErrorType parse(String name) {
    ErrorType[] errorTypes = ErrorType.values();
    for (ErrorType errorType : errorTypes) {
      if (errorType.name().equals(name)) {
        return errorType;
      }
    }
    return UNKNOWN;
  }
}
