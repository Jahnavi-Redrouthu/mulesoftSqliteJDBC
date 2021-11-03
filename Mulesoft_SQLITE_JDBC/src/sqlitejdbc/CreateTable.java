package sqlitejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String args[])
	{
		try
		{			 
			Connection con=null;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Class Loaded");
			con = DriverManager.getConnection("jdbc:sqlite:mulejdbc.db");
			System.out.println("Connection Established");
			
			Statement stmt=con.createStatement();
			String qry="create table movie_tb(mid int primary key not null,"
					+ "mname varchar(30) not null,"
					+ "theatrename varchar(30) not null,"
					+ "mrating decimal(10,4) not null)";
			stmt.executeUpdate(qry);
			
			System.out.println("Table Created");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
