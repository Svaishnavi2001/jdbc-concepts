package com.cat.jdbclearn;

// ACID properties   (setAutoCommit(false),rollback(),commit())

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Prg10 {
	
	private static Connection con;
	private static int i;
	static String update_query="update employee set salary=salary-? where name=?";
	
	static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
			con.setAutoCommit(false);
			
		boolean res=transaction();
		
		if(res) {
			con.commit();
		}
		else {
			con.rollback();
		}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
            e.printStackTrace();
		}
    }

	private static boolean  transaction() {
		
		System.out.println("Enter the senders details");
		String sender  = scan.next();
		
		System.out.println("Enter the receivers details");
		String receiver  = scan.next();
		
		System.out.println("Enter the amount to be transfered");
		int amount = scan.nextInt();
		
		boolean b1=checkBalance(sender,amount);
		if(b1) {
			
		int x=updateBalance(sender, amount);
		int y=updateBalance(receiver,-amount);
		
		boolean b=validation(x,y);
		
		return  b;
		}
		else{
			System.out.println("Insufficient balance");
			return false;
		}
	}

	private static boolean checkBalance(String sender, int amount) {
		
		String query="select salary from employee where name=?";
		
		try {
			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1,sender);
			
			ResultSet res = statement.executeQuery();
			res.next();
			int salary = res.getInt(1);
			if(salary >=amount) {
				return true;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}

	private static boolean validation(int x, int y) {
		
		System.out.println("Do you want to proceed with the transaction");
			String s = scan.next();
			if(x==1 && y==1 && s.equalsIgnoreCase("Yes")) {
			
				return true;
		}
		return false;
	}

	private static int  updateBalance(String sender, int amount) {
		
		try {
			
			PreparedStatement statement = con.prepareStatement(update_query);
			
			statement.setInt(1,amount);
			statement.setString(2, sender);
			 
			i= statement.executeUpdate();
			
			return i;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	       return i;
	}
}
