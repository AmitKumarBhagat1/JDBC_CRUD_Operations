package CRUD_Operation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Product_Management {

		public static void main(String[] args) throws SQLException {
			
			 /*
			 try {
				String url="jdbc:mysql://localhost:3306/MILK_PRODUCTS";
				String user="root";
				String psw="======";
				
				Connection con=DriverManager.getConnection(url, user, psw);
				
				Statement stm=con.createStatement();
				//stm.execute("CREATE DATABASE MILK_PRODUCTS");
				stm.execute("CREATE TABLE product(qrNumber int(10)Primary Key,name varchar(20),weight float(5),price float(8))");
				System.out.println("Table created ....");	
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			 */
			while(true)
			{
				System.out.println("\n MILK PRODUCT MANAGEMENT........\n");
				System.out.println("1:Add Items  2:Check Store  3:Update Items  4:Remove Items  ");
				Scanner sc =new Scanner(System.in);
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:System.out.println("QR code Number of the Product");
						   int qrNumber=sc.nextInt();
						   sc.nextLine();
						   System.out.println("Name of the Product");
						   String name=sc.nextLine();
						   System.out.println("Weight of the Product");
						   float weight=sc.nextFloat();
						   System.out.println("Price of the product");
						   float price=sc.nextFloat();
						   
						   Products pro=new Products(qrNumber, name, weight, price);
						   ProductDao.addItems(pro);
						   System.out.println(name+"  Product is Added...");
						   break;
					
					case 2: System.out.println("List of the available Product.......");
						    ArrayList<Products> alist=ProductDao.checkStore();
							for(Products prod:alist)
							{
								System.out.println(prod);
							}
							break;
					case 3:System.out.println("QR Code of the Product");
						   qrNumber=sc.nextInt();
						   sc.nextLine();
						   if(null != ProductDao.qr(qrNumber))
							{
							   System.out.println("1:name   2:Weight   3:Price");
							   int update=sc.nextInt();
							   sc.nextLine();
							   switch (update) {
							   case 1: 
							   		System.out.println("Update Name of the Product");
							   	   	name=sc.nextLine();
							   	    ProductDao.updateName(qrNumber, name);
							   	    System.out.println("Updated name is "+name+" ...");
							   	    break;    
							   case 2: 
							   		System.out.println("Update weight of the Product");
							   	   	weight=sc.nextFloat();
							   	    ProductDao.updateWeight(qrNumber, weight);
							   	    System.out.println("Updated weight is "+weight+" ...");
							   	    break;
							   case 3: 
							   		System.out.println("Update Price of the Product");
							   	   	price=sc.nextFloat();
							   	    ProductDao.updatePrice(qrNumber, price);
							   	    System.out.println("Updated price is "+price+" ...");
							   	    break;
							   default:
									throw new IllegalArgumentException("Unexpected value: " + choice);
						   						}
							}
						   else {
								System.err.println(qrNumber+"   Record not found....");
							}
						   break;
					case 4:System.out.println("QR-Code of the Product");
						   qrNumber=sc.nextInt();
						   if(null != ProductDao.qr(qrNumber))
							{
								ProductDao.removeItem(qrNumber);
								System.out.println("Product removed");
							}else {
								System.err.println(qrNumber+"  Record not found.");
							}
						   break;
						  
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					
				}  
			} 
			
			
		}

	}


