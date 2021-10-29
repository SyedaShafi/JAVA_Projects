package todolist_project;

import java.sql.*;

public class CP {

	static Connection con = null;
	public static  Connection createConnection()
	{
		try 
		{
			String url = "jdbc:mysql://localhost:3306/todolist?userSSL=false";
			con = DriverManager.getConnection(url, "root", "root3306" );
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
	
}
