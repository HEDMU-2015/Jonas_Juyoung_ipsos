package data;

import java.sql.Connection;

public interface DataAccess {
	public Connection getConnection();
	public void close();
	public void commit();
	public void rollback();
	
	

}
