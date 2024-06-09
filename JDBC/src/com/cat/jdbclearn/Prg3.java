package com.cat.jdbclearn;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Prg3 {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			DatabaseMetaData metaData = connection.getMetaData();
			
			String databaseProductName = metaData.getDatabaseProductName();
			System.out.println(databaseProductName);
			
		    String databaseProductVersion = metaData.getDatabaseProductVersion();
			System.out.println(databaseProductVersion);

            int databaseMinorVersion = metaData.getDatabaseMinorVersion();
            System.out.println(databaseMinorVersion);
            
            int databaseMajorVersion = metaData.getDatabaseMajorVersion();
            System.out.println(databaseMajorVersion);
            
            
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
