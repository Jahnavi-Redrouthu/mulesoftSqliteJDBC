package sqlitejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord {
	public static void main(String[] args) {
		try
		{			 
			Connection con=null;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Class Loaded");
			con = DriverManager.getConnection("jdbc:sqlite:mulejdbc.db");
			System.out.println("Connection Established");
			
			Statement stmt = con.createStatement();
			int mid;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Movie ID : ");
			mid = sc.nextInt();
			
			String qry="delete from movie_tb where mid='"+mid+"'";
			stmt.executeUpdate(qry);
			System.out.println("Record Deleted");
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}

}
