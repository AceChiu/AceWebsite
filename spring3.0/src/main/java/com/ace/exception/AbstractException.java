package com.ace.exception;

/**
 * @author: ACE.CHIU
 * @create: 2022-06-30
 */
public abstract class AbstractException extends RuntimeException {

  private static final long serialVersionUID = -1704508525572788612L;

  public AbstractException() {
    super();
  }

  public AbstractException(String message) {
    super(message);
  }

  public AbstractException(String message, Throwable cause) {
    super(message, cause);
  }

  public AbstractException(Throwable cause) {
    super(cause);
  }

  public AbstractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public abstract String getErrorCode();
}