package org.com.demo.logger.factory;

import org.com.demo.logger.LoggerConsole;
import org.com.demo.logger.LoggerDatabase;
import org.com.demo.logger.LoggerFile;
import org.com.demo.logger.config.DemoConfiguration;
import org.com.demo.logger.config.DefaultConfiguration;
import org.com.demo.logger.enums.LoggerType;
import org.com.demo.logger.exception.LoggerTypeException;
import org.com.demo.logger.interfaces.DemoLogger;

public class LoggerFactory {
	
	private LoggerFactory() {
		super();
	}
	
	public static DemoLogger getLogger(String type) {
		if (LoggerType.FILE.getType().equals(type)) {
			return new LoggerFile(new DefaultConfiguration());
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new LoggerConsole(new DefaultConfiguration());
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new LoggerDatabase(new DefaultConfiguration());
		} else {
			throw new LoggerTypeException("Invalid configuration | Logger type not valid!");
		}
	}
	
	public static DemoLogger getLogger(String type, DemoConfiguration configuration) {
		if (LoggerType.FILE.getType().equals(type)) {
			return new LoggerFile(configuration);
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new LoggerConsole(configuration);
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new LoggerDatabase(configuration);
		} else {
			throw new LoggerTypeException("Logger type not valid!");
		}
	}

}
