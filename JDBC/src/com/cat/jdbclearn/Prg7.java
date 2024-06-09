package com.cat.jdbclearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Insertion of 1 data(by user)

public class Prg7 {

	public static void main(String[] args) {
		
		String url= "jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
		
		Scanner scan=new Scanner(System.in);
		
		String insert_query="insert into employee(id,name,email,dept,salary) values(?,?,?,?,?)";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Prg6.printEmployeeDetails(connection);
			PreparedStatement prepareStatement = connection.prepareStatement(insert_query);
			
			System.out.println("Enter id ");
			int id=scan.nextInt();
			System.out.println("Enter name ");		
			String name=scan.next();
			System.out.println("Enter email ");
			String email=scan.next();
			System.out.println("Enter dept ");
			String dept=scan.next();
			System.out.println("Enter salary ");
			int salary=scan.nextInt();
			
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setString(3, email);
			prepareStatement.setString(4, dept);
			prepareStatement.setInt(5, salary);
			
			int i = prepareStatement.executeUpdate();
			System.out.println(i);
			
			
			Prg6.printEmployeeDetails(connection);
			
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			} catch (SQLException e) {
                e.printStackTrace();
			} 
	}

}
