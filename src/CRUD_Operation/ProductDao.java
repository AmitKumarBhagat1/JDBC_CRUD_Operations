package CRUD_Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductDao {
	
	public static void addItems(Products pro) throws SQLException
	{
		Connection con=DB.connect();
		String query=CRUD_Query.insert;
		PreparedStatement preStm=con.prepareStatement(query);
		preStm.setInt(1, pro.getQrNumber());
		preStm.setString(2, pro.getName());
		preStm.setFloat(3, (float) pro.getWeight());
		preStm.setFloat(4, (float) pro.getPrice());
		preStm.executeUpdate();
		preStm.close();
	}
	public static ArrayList<Products> checkStore() throws SQLException {
		ArrayList<Products> al=new ArrayList<>();
		Connection con=DB.connect();
		String query=CRUD_Query.select;
		Statement stm=con.prepareStatement(query);
		ResultSet rs=stm.executeQuery(query);
		while(rs.next())
		{
			Products pro=new Products(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4));
			al.add(pro);
		}
		stm.close();
		return al;
		
	}
	public static void updateName(int qrNumber,String name) throws SQLException
	{
		Connection con=DB.connect();
		String query=CRUD_Query.updateN;
		PreparedStatement preStm=con.prepareStatement(query);
		preStm.setInt(2, qrNumber);
		preStm.setString(1, name);
		preStm.executeUpdate();
		preStm.close();
	}
	public static void updateWeight(int qrNumber,double weight) throws SQLException
	{
		Connection con=DB.connect();
		String query=CRUD_Query.updateW;
		PreparedStatement preStm=con.prepareStatement(query);
		preStm.setInt(2, qrNumber);
		preStm.setDouble(1, weight);
		preStm.executeUpdate();
		preStm.close();
	}
	public static void updatePrice(int qrNumber,double price) throws SQLException
	{
		Connection con=DB.connect();
		String query=CRUD_Query.updateP;
		PreparedStatement preStm=con.prepareStatement(query);
		preStm.setInt(2, qrNumber);
		preStm.setDouble(1, price);
		preStm.executeUpdate();
		preStm.close();
	}
	public static String qr(int qrNumber)throws SQLException {
		Connection con=DB.connect();
		String query=CRUD_Query.qrCode;
		PreparedStatement preStm=con.prepareStatement(query);
		preStm.setInt(1,qrNumber);
		ResultSet rs=preStm.executeQuery();
		String dbQrNumber = null;
		while(rs.next())
		{
			dbQrNumber = String.valueOf(rs.getInt(1));
		}
		preStm.close();
		return dbQrNumber;
	    }
	public static void removeItem(int qrNumber)throws SQLException {
		Connection con=DB.connect();
		String query=CRUD_Query.delete;
		PreparedStatement preStm=con.prepareStatement(query);
		preStm.setInt(1, qrNumber);
		preStm.executeUpdate();
		preStm.close();
		
	}

}
