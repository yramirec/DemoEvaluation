package org.com.demo.logger.resources;

import java.io.Serializable;
import java.util.logging.ConsoleHandler;

import org.com.demo.logger.config.DemoConfiguration;

public class ConsoleManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ConsoleManager instance = null;
	
	private ConsoleManager(DemoConfiguration configuration) {
		super();
	}
	
	public static synchronized ConsoleManager getInstance(DemoConfiguration configuration) {
		if (instance == null) {
			instance = new ConsoleManager(configuration);
		}
		return instance;
	}
	
	public ConsoleHandler getConsoleHandler() {
		return new ConsoleHandler();
	}

}
