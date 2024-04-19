package CRUD_Operation;

public class Products {
	private int qrNumber;
	private String name;
	private double weight;
	private double price;

	public Products(int qrNumber, String name, double weight, double price) {
		super();
		this.qrNumber = qrNumber;
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public int getQrNumber() {
		return qrNumber;
	}
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [qrNumber=" + qrNumber + ", name=" + name + ", weight=" + weight + ", price=" + price + "]";
	}

}
