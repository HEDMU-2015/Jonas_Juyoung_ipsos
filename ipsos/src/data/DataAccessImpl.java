package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessImpl implements DataAccess {

	private static final String CONNECTION_URL = "jdbc:hsqldb:hsql://localhost/mydatabase";
	private static final String DB_USER = "SA";
	private static final String DB_PASSWORD = "";
	private Connection connection = null;

	public DataAccessImpl(){
		try {
			this.connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

	@Override
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Close : Connection is not available.", e);
		}
	}

	@Override
	public void commit() {
		try {
			this.connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException("Commit : Connection is not available.", e);
		}
	}

	@Override
	public void rollback() {
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			throw new RuntimeException("RollBack : Connection is not available.", e);
		}
	}
}


