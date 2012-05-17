package de.soappatrol.demo;

import java.sql.*;
import javax.sql.*;

public class App{

	public static void main(String args[]){
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * FROM test";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection (dbUrl,"test","test");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		
			while (rs.next()) {
				String id = rs.getString(1);
				System.out.println(id);
			}
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				rs.close();
				stmt.close();
				con.close();
			}catch (Exception e)
			{
				System.out.println("Could not close things...");
			}
			
		}
	}

} 
