package com.signup;

import java.sql.*;

public class DataBase {

	static boolean flag = false;
	public static boolean insertionOfData(String firstName, String lastName, String emailId, String password) throws SQLException {
		Connection connection = CP.createConnection();
		String query = "insert into users (firstName, lastName, emailId, password) values(?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, firstName);
		statement.setString(2,lastName);
		statement.setString(3, emailId);
		statement.setString(4, password);
		
		statement.executeUpdate();
		flag = true;
		
		return flag;
	}


}
