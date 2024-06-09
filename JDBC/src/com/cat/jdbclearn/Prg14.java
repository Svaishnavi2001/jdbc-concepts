package com.cat.jdbclearn;

//BLOB

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prg14 {

	public static void main(String[] args) {

         String url="jdbc:mysql://localhost:3306/JDBC";
         String username="root";
         String password="root";
         
        Scanner sc=new Scanner(System.in);
        
         try {
        	 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			String query="update employee set dp=? where id=?";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			System.out.println("Enter the id value");
			int id = sc.nextInt();
			statement.setInt(2, id);
			
			FileInputStream fis=new FileInputStream("C:\\Users\\1rn19\\Documents\\New folder\\java\\JDBC\\image\\img.jpg");
			
			statement.setBinaryStream(1, fis);
			
			int i = statement.executeUpdate();
			System.out.println(i);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
             e.printStackTrace();
             
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
