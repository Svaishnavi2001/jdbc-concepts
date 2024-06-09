package com.cat.jdbclearn;

//CLOB

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prg15 {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";

		Scanner sc=new Scanner(System.in);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,username,password);
			
			String query="update employee set intro=? where id=?";
			PreparedStatement statement = con.prepareStatement(query);
			
			System.out.println("Enter the id value");
			int id = sc.nextInt();
			statement.setInt(2, id);
			
			FileReader fr=new FileReader("C:\\Users\\1rn19\\Documents\\New folder\\java\\JDBC\\image\\intro");
			statement.setCharacterStream(1,fr);
			
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


