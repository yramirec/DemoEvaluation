package org.com.demo.logger;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;
import org.com.demo.logger.config.DemoConfiguration;
import org.com.demo.logger.exception.MessageException;
import org.com.demo.logger.interfaces.DemoLogger;
import org.com.demo.logger.resources.FileManager;

public class LoggerFile implements DemoLogger {
	
	private FileManager manager;
	
	public LoggerFile(DemoConfiguration configuration) {
		this.manager = new FileManager(configuration);
		logger.addHandler(this.manager.getFileHandler());
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		logger.log(Level.INFO, message);
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
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
