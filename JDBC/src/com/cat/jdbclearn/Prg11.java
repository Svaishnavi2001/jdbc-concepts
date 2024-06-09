package com.cat.jdbclearn;

//Stored procedures (Count the no. of employees of a specific department)

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Prg11 {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
	    String password="root";

	    Scanner sc=new Scanner(System.in);
	    
	    try {
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			CallableStatement prepareCall = con.prepareCall("{call count_emp(?,?)}");
			
			System.out.println("Enter department name");
			prepareCall.setString(1, sc.next());
			
			prepareCall.registerOutParameter(2,Types.INTEGER);
			
			prepareCall.execute();
			
			int i = prepareCall.getInt(2);
			System.out.println(i);
			 
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
             e.printStackTrace();
		}
	}

}
