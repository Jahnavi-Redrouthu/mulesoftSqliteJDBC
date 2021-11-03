package sqlitejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewRecords {
	public static void main(String args[])
	{
		try
		{			 
			Connection con=null;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Class Loaded");
			con = DriverManager.getConnection("jdbc:sqlite:mulejdbc.db");
			System.out.println("Connection Established");
			
//			PreparedStatement pstmt=con.prepareStatement("select * from movie_tb");
			Statement stmt = con.createStatement();
			String qry="select * from movie_tb";
			ResultSet rs=stmt.executeQuery(qry);
			int count=1;
			while(rs.next())
			{
				System.out.println("********************************");
				System.out.println("Movie Record : "+count);
				System.out.println("Movie ID : "+rs.getInt(1));
				System.out.println("Movie Name : "+rs.getString(2));
				System.out.println("Theatre Name : "+rs.getString(3));
				System.out.println("Movie Rating : "+rs.getDouble(4));
				count=count+1;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
