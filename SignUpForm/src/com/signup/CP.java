package com.signup;

import java.sql.*;

public class CP {

	static Connection connection;
	
	public static Connection createConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/user_information?userSSL=false";
		connection = DriverManager.getConnection(url,"root", "root3306");
		return connection;
	}
	
}
