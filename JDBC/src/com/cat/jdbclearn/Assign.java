package com.cat.jdbclearn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Assign {

	private static ResultSet resultSet;

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";

		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url,username,password);

			statement = connection.createStatement();

			selectQuery(connection,statement,resultSet);
			insertQuery(statement,resultSet);
			updateQuery(statement,resultSet);
			deleteQuery(statement,resultSet);

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void selectQuery(Connection connection, Statement statement, ResultSet resultSet2) {

		String query="select * from employee";

		try {

			resultSet=  statement.executeQuery(query);

			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+ " "+resultSet.getString(2)+ " "+
						resultSet.getString(3)+ " "+resultSet.getString(4)+ " "+resultSet.getInt(5));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insertQuery(Statement statement, ResultSet resultSet2) {

		String insert_query="insert into employee(id, name, email, dept, salary) values (12,'suma','suma@gmail.com','sales',30000)";

		try {

			int i = statement.executeUpdate(insert_query);
			System.out.println(i);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static void updateQuery(Statement statement, ResultSet resultSet2) {

		String update_query="update employee set salary=salary+5000 where dept='finance' ";

		try {

			int i = statement.executeUpdate(update_query);
			System.out.println(i);


		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	private static void deleteQuery(Statement statement, ResultSet resultSet2) {

		String delete_query="delete from employee where id=11";

		try {

			int i = statement.executeUpdate(delete_query);
			System.out.println(i);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
