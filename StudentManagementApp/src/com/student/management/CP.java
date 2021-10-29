package com.student.management;

import java.sql.*;

public class CP {
	
	static Connection connection;
	
	public static Connection createC()
	{
		try{
//			Class.forName("com.mysql.jdbc.Driver");// no need to use it
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_demot?userSSL=false","root","root3306");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
}
