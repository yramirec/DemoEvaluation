package org.com.demo.logger;

import java.text.DateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;
import org.com.demo.logger.config.DemoConfiguration;
import org.com.demo.logger.enums.MessageType;
import org.com.demo.logger.exception.MessageException;
import org.com.demo.logger.interfaces.DemoLogger;
import org.com.demo.logger.resources.DatabaseManager;

public class LoggerDatabase implements DemoLogger {
	
	private DatabaseManager manager;
	
	public LoggerDatabase(DemoConfiguration configuration) {
		this.manager = DatabaseManager.getInstance(configuration);
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		String errorMessage = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.MESSAGE.getId());
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
		}
		String errorMessage = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.WARNING.getId());
	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}
		String errorMessage = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.ERROR.getId());
	}

}