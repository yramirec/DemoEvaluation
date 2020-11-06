package org.com.demo.logger.resources;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.com.demo.logger.config.DemoConfiguration;

public class DatabaseManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private static DatabaseManager instance = null;
	private DemoConfiguration configuration;
	
	private DatabaseManager(DemoConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public static synchronized DatabaseManager getInstance(DemoConfiguration configuration) {
		if (instance == null) {
			instance = new DatabaseManager(configuration);
		}
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(configuration.getProperty("logger.bd.jdbcDriver"));
			String userName = configuration.getProperty("logger.bd.userName");
			String password = configuration.getProperty("logger.bd.password");
			connection = DriverManager.getConnection(configuration.getProperty("logger.bd.dbUrl"), userName, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("Connection DB error.", e);
		}
		return connection;
	}
	
	public Statement getStatment(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException("Get Statment Connection error.", e);
		}
	}
	
	public void createLogTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.executeUpdate("create table IF NOT EXISTS Log_Values(message varchar(255), type int)");
		} catch (SQLException e) {
			throw new RuntimeException("Create log table BD error.", e);
		} finally {
			//close
		}
	}

	public void insertMessageBD(String message, int messageType) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.execute("INSERT INTO Log_Values(message, type) VALUES('" + message + "', " + String.valueOf(messageType) + ")");
		} catch (SQLException e) {
			throw new RuntimeException("Insert message BD error.", e);
		} finally {
			//close
		}
	}
	

}
