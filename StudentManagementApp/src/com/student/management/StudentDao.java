package com.student.management;

import java.sql.*;

public class StudentDao {

	public static boolean insertStudentToDB(Student st)
	{
		boolean f = false;
		try {
			Connection connection = CP.createC();
			String query = "insert into users(name,phone,city) value(?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			//set the value of parameters in the query
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute 
			pstmt.executeUpdate();
			f = true;
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static boolean deleteStudent(int userId) {

		boolean f = false;
		try {
			Connection connection = CP.createC();
			String query = "delete from users where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			//set the value of parameters in the query
			pstmt.setInt(1, userId);
			
			//execute 
			pstmt.executeUpdate();
			f = true;
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		
		try {
			Connection connection = CP.createC();
			String query = "select * from users";
			
			Statement stmt = connection.createStatement();
			ResultSet rSet = stmt.executeQuery(query);
						
			while(rSet.next())
			{
				int id = rSet.getInt(1);
				String name = rSet.getString(2);
				String phone = rSet.getString("phone");
				String city = rSet.getString("city");
				System.out.println(id+"\n"+name+"\n"+phone+"\n"+city);
				
				System.out.println("\n+============+\n");
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

	
	
	public static boolean updateStudent(Student st) {
		
		boolean f = false;
		try {
			Connection connection = CP.createC();
			String query = "update users set name=?, phone=?, city=? where id=?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, st.getStudentId());
			
			//execute 
			pstmt.executeUpdate();
			f = true;
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}

	
	
}
