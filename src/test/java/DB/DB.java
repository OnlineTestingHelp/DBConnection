package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB {
	
	@Test
	public void executeQuery() throws ClassNotFoundException, SQLException {
		
		//Setting the driver
		Class.forName("com.mysql.jdbc.Driver");  
		
		//Open a connection to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "root", "root@123");
		Statement st=con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM customers;");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3));
		}
		con.close();
		
	}
	
	@Test
	public void executeUpdate() throws ClassNotFoundException, SQLException {
		
		//Setting the driver
		Class.forName("com.mysql.jdbc.Driver");  
		
		//Open a connection to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "root", "root@123");
		Statement st=con.createStatement();
		
		//Executing the update query
		st.executeUpdate("Update customers set first_name='Harry' where customer_id=1");
		
		ResultSet rs = st.executeQuery("SELECT * FROM customers;");
		System.out.println("-------------------------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3));
		}
		con.close();
	}

}
