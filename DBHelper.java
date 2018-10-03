package com.yodlee.engg.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBHelper {
	
	private static Connection conn;
    private static ResourceBundle rb;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    
	
	public static Connection  getDBConnection()
	{
		
    	rb=ResourceBundle.getBundle("com.yodlee.engg.resources/db");
    	driver=rb.getString("driver");
    	username=rb.getString("user");
    	password=rb.getString("password");
    	url=rb.getString("url");
    	try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		
		return conn;
		
	}
	
}
