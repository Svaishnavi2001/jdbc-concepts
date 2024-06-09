package com.cat.jdbclearn;

// Crude operations

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prg2 {

     public static void main(String[] args) {

		String url= "jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";

		String insert_query="insert into employee(id, name, email, dept, salary) values (10,'micheal','micheal@gmail.com','',25000)";

		String update_query="update employee set salary=salary+5000 where dept='finance' ";

		String delete_query="delete from employee where id=8";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url,username,password);

			Statement statement = connection.createStatement();

			//int i = statement.executeUpdate(insert_query);
			
			//int i = statement.executeUpdate(update_query);
			
			int i = statement.executeUpdate(delete_query);

			System.out.println(i);


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
