package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null; //to connect the data base
		Statement st = null; //to prepare a search sql 
		ResultSet rs = null; //result of the search sql 
		
		try {
			conn = DB.getConnection(); //this do the connection
			
			st = conn.createStatement(); //to instantiate the st
			
			//that way you can use SQL commands:
			rs = st.executeQuery("select * from department"); 
			
			while(rs.next()) /*it goes next till find nothing*/ {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		finally {
			DB.closeResultset(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
