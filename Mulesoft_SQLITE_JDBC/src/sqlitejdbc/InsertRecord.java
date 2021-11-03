package sqlitejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecord {

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
				System.out.println("Enter Movie ID : ");
				mid = sc.nextInt();
				System.out.println("Enter Movie Name : ");
				mname = sc.next();
				System.out.println("Enter Theatre Name : ");
				theatrename = sc.next();
				System.out.println("Enter Movie Rating : ");
				mrating = sc.nextDouble();
				
				PreparedStatement pstmt=con.prepareStatement("insert into movie_tb values(?,?,?,?)");
				pstmt.setInt(1, mid);
				pstmt.setString(2,mname);
				pstmt.setString(3,theatrename);
				pstmt.setDouble(4,mrating);
				pstmt.executeUpdate();
				System.out.println("Record is Inserted");
				con.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

}
