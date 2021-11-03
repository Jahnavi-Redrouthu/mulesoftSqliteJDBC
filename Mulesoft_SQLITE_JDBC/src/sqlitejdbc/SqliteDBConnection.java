package sqlitejdbc;
import java.sql.*;
public class SqliteDBConnection {
	public static void main(String args[])
	{
		try
		{			 
			Connection con=null;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Class Loaded");
			con = DriverManager.getConnection("jdbc:sqlite:mulejdbc.db");
			System.out.println("Connection Established");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
