package sqlitejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRecord {
	public static void main(String[] args) {
		try
		{			 
			Connection con=null;
			Class.forName("org.sqlite.JDBC");
			System.out.println("Class Loaded");
			con = DriverManager.getConnection("jdbc:sqlite:mulejdbc.db");
			System.out.println("Connection Established");
			
			int mid;
			String mname=null;
			String theatrename=null;
			double mrating;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Movie ID for which you want to change rating : ");
			mid = sc.nextInt();
			System.out.println("Enter Movie Rating : ");
			mrating = sc.nextDouble();
			
			PreparedStatement pstmt=con.prepareStatement("update movie_tb set mrating=? where mid=?");
			pstmt.setDouble(1, mrating);
			pstmt.setInt(2,mid);
			pstmt.executeUpdate();
			System.out.println("Record is Updated");
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
