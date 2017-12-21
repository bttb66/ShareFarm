package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionManager {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "";
    private static DataSource ds = null;
    
    public ConnectionManager() {
    	try {
			BasicDataSource bds = new BasicDataSource();
	        bds.setDriverClassName(DB_DRIVER);
	        bds.setUrl(DB_URL);
	        bds.setUsername(DB_USERNAME);
	        bds.setPassword(DB_PASSWORD);     
			ds = bds;
			
			// ? ?™?˜™? ?™?˜™: WAS? ?™?˜™ DataSource? ?™?˜™ ? ?‹±?š¸?˜™? ?™?˜™ ? ?™?˜™? ï¿?: 
			// Context init = new InitialContext();
			// ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDS");
		} catch (Exception ex) {
			ex.printStackTrace();
		}    	   
    }

    public Connection getConnection() {
    	Connection conn = null;
    	try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
    }
    
    public void close() {
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// ? ?™?˜™? ?™?˜™ ?™œ? ?™?˜™?™” ? ?™?˜™? ?™?˜™? ?™?˜™ Connection ? ?™?˜™ ? ?™?˜™? ?™?˜™? ?™?˜™ ? ?™?˜™?™œ? ?™?˜™?™” ? ?™?˜™? ?™?˜™? ?™?˜™ Connection ? ?™?˜™? ?™?˜™ ? ?™?˜™? ï¿?
	public void printDataSourceStats() {
		try {
			BasicDataSource bds = (BasicDataSource) ds;
			System.out.println("NumActive: " + bds.getNumActive());
			System.out.println("NumIdle: " + bds.getNumIdle());
		} catch (Exception ex) {
			ex.printStackTrace();
		}   
	}
}
