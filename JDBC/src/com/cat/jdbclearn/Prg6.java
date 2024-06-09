package com.cat.jdbclearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Prg6 {
	
	static String query="select * from employee";	
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
		
		String update_query="update employee set salary=salary+? where dept=?";
		
		Scanner scan=new Scanner(System.in);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			System.out.println("Before updating");
			printEmployeeDetails(connection);
			
			PreparedStatement prepareStatement = connection.prepareStatement(update_query);
			System.out.println("Enter deptname and salary");
			
			String dept = scan.next();
			int salary = scan.nextInt();
			
			
			prepareStatement.setString(1, dept);
			prepareStatement.setInt(2, salary);
			
			int i = prepareStatement.executeUpdate();
			System.out.println(i);
			
			System.out.println("After updating");
			printEmployeeDetails(connection);
			
		} catch (ClassNotFoundException e) {
			
              e.printStackTrace();
              
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	static void printEmployeeDetails(Connection connection) {
		
			
		try {
			
			Statement statement = connection.createStatement();
			
			ResultSet res = statement.executeQuery(query);
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+
			   res.getString(4)+" "+res.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
