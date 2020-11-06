package org.com.demo.logger.config;

public class DefaultConfiguration extends DemoConfiguration {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getProperty(final String property) {
		String message = null;
		if (property.equals("logger.logFilePath")) {
			message = "./data/logFile.txt";
		} else if (property.equals("logger.bd.userName")) {
			message = "admin";
		} else if (property.equals("logger.bd.password")) {
			message = "admin";
		} else if (property.equals("logger.bd.jdbcDriver")) {
			message = "org.h2.Driver";
		} else if (property.equals("logger.bd.dbUrl")) {
			message = "jdbc:h2:./data/demoDB";
		}
		
		return message;
	}

}