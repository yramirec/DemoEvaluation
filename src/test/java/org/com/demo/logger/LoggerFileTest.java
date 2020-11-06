package org.com.demo.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.com.demo.logger.LoggerFile;
import org.com.demo.logger.config.DefaultConfiguration;
import org.com.demo.logger.enums.LoggerType;
import org.com.demo.logger.exception.LoggerTypeException;
import org.com.demo.logger.factory.LoggerFactory;
import org.com.demo.logger.interfaces.DemoLogger;
import org.com.demo.logger.resources.FileManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerFileTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_FileType() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
        assertEquals(true, logger instanceof LoggerFile);
    }
	
	@Test(expected = LoggerTypeException.class)
    public void testLoggerFactory_TypeNoValid() {
		DemoLogger logger = LoggerFactory.getLogger("noValid");
		//...
    }
	
	@Test
    public void testFileManager_HandlerValid() {
		FileManager fileManager = new FileManager(new DefaultConfiguration());
		assertNotNull(fileManager.getFileHandler());
    }
	
	@Test
    public void testLoggerFile_addMessageInfo() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test - Message Info ");
        assertEquals(true, logger instanceof LoggerFile);
    }
	
	@Test
    public void testLoggerFile_addMultipleMessage() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test Multiple - Message Info!");
		logger.addWarning("Test Multiple - Message Warning!");
        assertEquals(true, logger instanceof LoggerFile);
    }
	
}
