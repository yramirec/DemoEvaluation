package org.com.demo.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.com.demo.logger.LoggerConsole;
import org.com.demo.logger.config.DefaultConfiguration;
import org.com.demo.logger.enums.LoggerType;
import org.com.demo.logger.factory.LoggerFactory;
import org.com.demo.logger.interfaces.DemoLogger;
import org.com.demo.logger.resources.ConsoleManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerConsoleTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_ConsoleType() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
        assertEquals(true, logger instanceof LoggerConsole);
    }
	
	@Test
    public void testConsoleManager_HandlerValid() {
		ConsoleManager consoleManager = ConsoleManager.getInstance(new DefaultConfiguration());
		assertNotNull(consoleManager.getConsoleHandler());
    }
	
	@Test
    public void testLoggerConsole_addMessageInfo() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
		logger.addMessage("Test Console - Message Info ");
        assertEquals(true, logger instanceof LoggerConsole);
    }
	
	@Test
    public void testLoggerConsole_addMultipleMessage() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
		logger.addMessage("Test Multiple Console - Message Info!");
		logger.addWarning("Test Multiple Console - Message Warning!");
		logger.addError("Test Multiple Console - Message Error!");
        assertEquals(true, logger instanceof LoggerConsole);
    }
	
}
