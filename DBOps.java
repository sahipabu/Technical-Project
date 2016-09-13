package com.onlinequiz;

import java.sql.*;

public class DBOps {
	private String url = new String();
	private String user = new String();
	private String pwd = new String();
	
	{
		url = "jdbc:oracle:thin:@10.14.5.88:1521/XE";
		user = "System";
		pwd = "sahithi";
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}
	
	public Connection establishDBConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver"); //Loading the driver
		Connection conn = DriverManager.getConnection(url,user,pwd); //Establishing connection to database
		System.out.println("Connection = "+conn);
		return conn;
	}
	
}
