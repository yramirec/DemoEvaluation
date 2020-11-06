package org.com.demo.logger;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;
import org.com.demo.logger.config.DemoConfiguration;
import org.com.demo.logger.exception.MessageException;
import org.com.demo.logger.interfaces.DemoLogger;
import org.com.demo.logger.resources.ConsoleManager;

public class LoggerConsole implements DemoLogger {
	
	private ConsoleManager manager;
	
	public LoggerConsole(DemoConfiguration configuration) {
		this.manager = ConsoleManager.getInstance(configuration);
		logger.addHandler(this.manager.getConsoleHandler());
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		logger.log(Level.INFO, message);
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		logger.log(Level.WARNING, message);
	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}
		logger.log(Level.SEVERE, message);
	}

}