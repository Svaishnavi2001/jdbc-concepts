package com.cat.jdbclearn;

// Display details of employee whose having highest salary

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Prg13 {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/JDBC";
        String username="root";
        String password="root";
        
        Scanner sc=new Scanner(System.in);
        
       try {
    	   
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
		Connection con = DriverManager.getConnection(url, username, password);
		
		CallableStatement prepareCall = con.prepareCall("{call retrieve_emp(?)}");
		
		System.out.println("Enter the salary");
		prepareCall.setInt(1, sc.nextInt());
		
		prepareCall.execute();
		
		ResultSet res = prepareCall.getResultSet();
		System.out.println(res);
		
		while(res.next()) {
			System.out.println(res.getInt(1)+ " "+res.getString(2)+ " "+
					res.getString(3)+ " "+res.getString(4)+ " "+res.getInt(5));
		}
	
		
	}  catch (ClassNotFoundException e) {
          e.printStackTrace();
          
	} catch (SQLException e) {
		  e.printStackTrace();
		
	
	}
  }
}


