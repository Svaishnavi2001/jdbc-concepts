package com.cat.jdbclearn;

// Selection of data(complete query)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prg1 {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";

		Connection con=null;
		Statement stmt=null;
		ResultSet result=null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url,username,password);

			stmt= con.createStatement();

			printDetails(stmt,result);

		} 
		catch (ClassNotFoundException |	 SQLException e) {
			e.printStackTrace();
		}
		finally {

			close(con, stmt, result);
		}
	}
	private static void printDetails(Statement stmt, ResultSet result) {


		String query="select * from employee";

		try {

			result=  stmt.executeQuery(query);

			while(result.next()) {
				System.out.println(result.getInt(1)+ " "+result.getString(2)+ " "+
						result.getString(3)+ " "+result.getString(4)+ " "+result.getInt(5));
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private static void close(Connection con, Statement stmt, ResultSet result) {
		try {
			if(result!=null) {
				result.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(con!=null) {
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
