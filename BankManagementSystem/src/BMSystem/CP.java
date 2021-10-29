package BMSystem;
import java.sql.*;
public class CP {
	static Connection conn;
	public static Connection createConnection()
	{
		try
		{
			String url = "jdbc:mysql://localhost:3306/bmsystem_data?userSSL=false";
			conn = DriverManager.getConnection(url,"root","root3306");
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return conn;
	}

}
