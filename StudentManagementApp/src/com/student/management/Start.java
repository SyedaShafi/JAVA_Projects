package com.student.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		while(true)
		{
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to UPDATE student");
			System.out.println("PRESS 5 to EXIT student");
			
			int c =Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				//add student
				System.out.println("Enter users name : ");
				String name = br.readLine();
				
				System.out.println("Enter users phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter users city : ");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				
				if(answer)
				{
					System.out.println("Data added successfully");
				}
				else
				{
					System.out.println("Something wrong");
				}
				
				
				
				System.out.println(st);
			}
			
			else if(c==2)
			{
				//delete student
				System.out.println("Enter student id to delete");
				int userId = Integer.parseInt(br.readLine());
				boolean answer = StudentDao.deleteStudent(userId);
				if(answer)
				{
					System.out.println("Data deleted");
				}
				else
				{
					System.out.println("something went wrong for deleting");
				}
			}
			
			else if(c==3)
			{
				//display student
				StudentDao.showAllStudent();
			}
			
			else if(c==4)
			{
				System.out.println("Enter the id to update");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter users name : ");
				String name = br.readLine();
				
				System.out.println("Enter users phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter users city : ");
				String city = br.readLine();
				
				Student st = new Student(id, name, phone, city);
				boolean answer = StudentDao.updateStudent(st);
				
				if(answer)
				{
					System.out.println("data updated");
				}
				
				else
				{
					System.out.println("somthing went wrong for updating data");
				}
			}
			
			else if(c==5)
			{
				//exit
				break;
			}
			else
			{
				
			}
		}
		
		System.out.println("Thank u :)");
		
	}

}
