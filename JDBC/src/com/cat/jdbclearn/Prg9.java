package com.cat.jdbclearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// Batch process

public class Prg9 {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
		
		String insert_query="insert into employee (id,name,email,dept,salary)values (?,?,?,?,?)";
	
		Scanner scan=new Scanner(System.in);
		String s;
      try {
    	  
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,username,password);
		
		System.out.println("Before updating");
		Prg6.printEmployeeDetails(con);
		PreparedStatement stmt = con.prepareStatement(insert_query);
		
		do {
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
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, dept);
			stmt.setInt(5, salary);
			
			stmt.addBatch();
			
			System.out.println("Do you want insert the record(Yes/No)");
			s = scan.next();
			
	     }while(s.equalsIgnoreCase("Yes"));
		   
		  int[] ar = stmt.executeBatch();
		  
		  for(int i=0;i<ar.length;i++) {
			  System.out.print(ar[i]);
		  }
		
		Prg6.printEmployeeDetails(con);
		
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}

}
