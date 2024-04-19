package CRUD_Operation;

public class CRUD_Query {
	
	static String insert="INSERT INTO product(qrNumber,name,weight,price) VALUES (?,?,?,?)";
	static String updateN="UPDATE product SET name=? where qrNumber=?";
	static String updateW="UPDATE product SET weight=? where qrNumber=?";
	static String updateP="UPDATE product SET price=? where qrNumber=?";
	static  String delete="DELETE FROM product WHERE qrNumber=?";
	static String select="SELECT * FROM product";
	static String qrCode="SELECT qrNumber FROM product where qrNumber = ?";

}
