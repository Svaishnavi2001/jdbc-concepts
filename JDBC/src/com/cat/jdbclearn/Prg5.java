package com.cat.jdbclearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//Prepared statement.(incomplete query)

public class Prg5 {

	public static void main(String[] args) {
		

		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
		
		 Scanner sc=new Scanner(System.in);
		
		String QUERY="select * from employee where dept=? "; 
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			PreparedStatement statement = connection.prepareStatement(QUERY);
			
			System.out.println("Enter the dept name");
			String dept = sc.next(); 
			
			statement.setString(1, dept);
			
			ResultSet res = statement.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getInt(1)+ " "+res.getString(2)+ " "+res.getString(3)+" "+
			    res.getString(4)+ " "+res.getInt(5));
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		

	

    }
}