package org.com.demo.logger.exception;

public class HandlerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HandlerException(String message) {
        super(message);
    }
	
	public HandlerException(String message, Throwable cause) {
        super(message, cause);
    }

}
