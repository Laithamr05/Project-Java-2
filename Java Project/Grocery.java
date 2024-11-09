
//Laith Amro
//1230018
//Dr. Mamoun Nawahda
//Section 3
import java.util.*;

public class Grocery extends StockItem { // Grocery class that extends StockItem

	private String name; // name of the grocery item
	private Calendar expiryDate; // expiry date of the grocery item
	private float weight; // weight of the grocery item

	public Grocery(String name, Calendar expiryDate, float weight, String brand, double discount, double price) { // constructor
																													// to
																													// initialize
																													// the
																													// grocery
																													// item
		super(brand, discount, price); // calling the parent constructor to set brand, discount, and price
		this.name = name; // setting name
		this.expiryDate = expiryDate; // setting expiry date
		this.weight = weight; // setting weight
	}

	public Grocery() { // default constructor
		super(); // calling the parent constructor
		// TODO Auto-generated constructor stub
	}

	public String getName() { // getter for name
		return name;
	}

	public void setName(String name) { // setter for name
		this.name = name;
	}

	public Calendar getExpiryDate() { // getter for expiry date
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) { // setter for expiry date
		this.expiryDate = expiryDate;
	}

	public float getWeight() { // getter for weight
		return weight;
	}

	public void setWeight(float weight) { // setter for weight
		this.weight = weight;
	}

	@Override
	public double calculateTax() { // method to calculate tax on the grocery item
		return price * 1.0575; // returning price with tax (5.75% tax)
	}

	@Override
	public String toString() { // method to return the string representation of the grocery item
		if (discount > 0.0) // if there is a discount
			return name + " ($" + price + ")" // returning name and price
					+ " has a discount of " + discount + "%, expiry date " + expiryDate + " (" + weight + "Kg), " // showing
																													// discount,
																													// expiry
																													// date,
																													// and
																													// weight
					+ "after discount price is " + price * (1 - discount) // showing price after discount
					+ ", after tax included (" + (price * (1 - discount)) * 1.0575; // showing price after tax
		return name + " ($" + price + ")" + "%, expiry date " + expiryDate + " (" + weight + "Kg)" // if no discount,
																									// just showing
																									// price, expiry
																									// date, and weight
				+ ", after tax included (" + price * 1.0575; // showing price after tax
	}

}
