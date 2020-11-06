package org.com.demo.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.com.demo.logger.LoggerDatabase;
import org.com.demo.logger.config.DefaultConfiguration;
import org.com.demo.logger.enums.LoggerType;
import org.com.demo.logger.enums.MessageType;
import org.com.demo.logger.factory.LoggerFactory;
import org.com.demo.logger.interfaces.DemoLogger;
import org.com.demo.logger.resources.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerDatabaseTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_DatabaseType() {
		DemoLogger logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
        assertEquals(true, logger instanceof LoggerDatabase);
    }
	
	@Test
    public void testDatabaseManager_BDConnectionValid() {
		DatabaseManager bdManager = DatabaseManager.getInstance(new DefaultConfiguration());
		try {
			assertTrue(bdManager.getConnection().isValid(0));
		} catch (SQLException e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void testDatabaseManager_insertMessage() {
		try {
			DatabaseManager bdManager = DatabaseManager.getInstance(new DefaultConfiguration());
			bdManager.createLogTable();
			bdManager.insertMessageBD("Test insert message DB", MessageType.MESSAGE.getId());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void testLoggerDatabase_addLog() {
		try {
			DemoLogger logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
			logger.addMessage("Test Multiple - Message Info!");
			logger.addWarning("Test Multiple - Message Warning!");
	        assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
}
