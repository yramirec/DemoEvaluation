package org.com.demo.logger.exception;

public class LogFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LogFileException(String message) {
        super(message);
    }
	
	public LogFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
