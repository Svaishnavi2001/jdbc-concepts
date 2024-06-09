package com.cat.jdbclearn;

//Count the no.of employees having salary having greater than a specific salary

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

  public class Prg12 {

	public static void main(String[] args) {

            String url="jdbc:mysql://localhost:3306/JDBC";
            String username="root";
            String password="root";
            
            Scanner sc=new Scanner(System.in);
            
            try {
            	
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection(url,username,password);
				
				CallableStatement prepareCall = con.prepareCall("{call count_emp_sal(?)}");
				
				System.out.println("Enter the salary");
				prepareCall.setInt(1,sc.nextInt());
				prepareCall.registerOutParameter(1, Types.INTEGER);
				
			    prepareCall.execute();
				
				int i = prepareCall.getInt(1);
				System.out.println(i);
				
			} catch (ClassNotFoundException e) {

                  e.printStackTrace();
                  
			} catch (SQLException e) {
				
                  e.printStackTrace();
			}
		
	}

}
