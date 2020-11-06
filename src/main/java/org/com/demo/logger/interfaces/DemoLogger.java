package org.com.demo.logger.interfaces;

import java.util.logging.Logger;

public interface DemoLogger {
	
	public static final Logger logger = Logger.getLogger("BelatrixLogger");
	
	public void addMessage(String message);
	public void addWarning(String message);
	public void addError(String message);

}
