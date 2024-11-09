//Laith Amro
//1230018
//Dr. Mamoun Nawahda
//Section 3
public class StockItem implements Comparable { // StockItem class for managing stock details
	protected String brand; // brand of the item
	protected double discount; // discount on the item
	protected double price; // price of the item

	public StockItem() { // default constructor
	}

	public StockItem(String brand, double discount, double price) { // constructor to set brand, discount, and price
		this.brand = brand; // setting the brand
		this.discount = discount; // setting the discount
		this.price = price; // setting the price
	}

	public String getBrand() { // getter for brand
		return brand;
	}

	public void setBrand(String brand) { // setter to update brand
		this.brand = brand;
	}

	public double getDiscount() { // getter for discount
		return discount;
	}

	public void setDiscount(double discount) { // setter to update discount
		this.discount = discount;
	}

	public double getPrice() { // getter for price
		return price;
	}

	public void setPrice(double price) { // setter to update price
		this.price = price;
	}

	public double calculateTax() { // method to calculate tax (recursive, which is incorrect)
		return calculateTax(); // returns tax calculation
	}

	@Override
	public String toString() { // method to convert stock item info to string
		if (discount > 0.0) // check if there is a discount
			return brand + " ($" + price + ")" + "has a discount of " + discount * 100 + "%."; // return with discount
																								// info
		return brand + " ($" + price + ")."; // return without discount info
	}

	@Override
	public boolean equals(Object obj) { // method to check equality of stock items
		if (!(obj instanceof StockItem)) // check if object is of type StockItem
			return false;
		return ((StockItem) obj).brand == this.brand && // check if brands match
				((StockItem) obj).discount == this.discount && // check if discounts match
				((StockItem) obj).price == this.price; // check if prices match
	}

	@Override
	public int compareTo(Object o) { // method to compare stock items
		// TODO Auto-generated method stub
		return 0; // default comparison
	}

}
