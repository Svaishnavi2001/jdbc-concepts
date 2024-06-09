package com.cat.jdbclearn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Prg4 {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Statement statement = connection.createStatement();
			
			String query="select * from employee";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			System.out.println(columnCount);
			
			for(int i=1;i<=columnCount;i++) {
				
				String columnName = metaData.getColumnName(i);
				String columnTypeName = metaData.getColumnTypeName(i);
				
				System.out.println(columnName+ " "+columnTypeName+ " ");
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
