package CRUD_Operation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
		
static Connection con=null; 
	
	public static Connection connect(){
		try 
		{
			String url="jdbc:mysql://localhost:3306/MILK_PRODUCTS";
			String user="root";
			String psw="***********";//confidential
			
			con=DriverManager.getConnection(url, user, psw);
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
