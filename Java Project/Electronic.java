//Laith Amro
//1230018
//Dr. Mamoun Nawahda
//Section 3

public class Electronic extends StockItem { // Electronic class that extends StockItem
	private String version; // version of the electronic item
	private String type; // type of the electronic item
	private double power; // power of the electronic item

	public Electronic() { // default constructor
	}

	public Electronic(String version, String type, double power, String brand, double discount, double price) { // constructor
																												// with
																												// parameters
																												// to
																												// initialize
																												// the
																												// electronic
																												// item
		super(brand, discount, price); // calling the parent constructor to set brand, discount, and price
		this.version = version; // setting version
		this.type = type; // setting type
		this.power = power; // setting power
	}

	public String getVersion() { // getter for version
		return version;
	}

	public void setVersion(String version) { // setter for version
		this.version = version;
	}

	public String getType() { // getter for type
		return type;
	}

	public void setType(String type) { // setter for type
		this.type = type;
	}

	public double getPower() { // getter for power
		return power;
	}

	public void setPower(double power) { // setter for power
		this.power = power;
	}

	@Override
	public double calculateTax() { // method to calculate the tax on the item
		// TODO Auto-generated method stub
		return price * 1.165; // returning price with tax (16.5% tax)
	}

	@Override
	public String toString() { // method to return the string representation of the electronic item
		return version + " ($" + price + ")" // returning version and price
				+ " with a discount of " + discount + "% in " + type + " " + power + "Watt." // showing discount, type,
																								// and power
				+ " after discount price is " + price * (1 - discount) // showing the price after discount
				+ ", after tax included (" + (price * (1 - discount)) * 1.165; // showing price after tax
	}
}
