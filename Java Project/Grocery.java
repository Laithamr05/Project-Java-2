
import java.util.*;

public class Grocery extends StockItem {

	private String name;
	private Calendar expiryDate;
	private float weight;

	public Grocery(String name, Calendar expiryDate, float weight, String brand, double discount, double price) {

		super(brand, discount, price);
		this.name = name;
		this.expiryDate = expiryDate;
		this.weight = weight;
	}

	public Grocery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public double calculateTax() {
		return price * 1.0575;
	}

	@Override
	public String toString() {
		if (discount > 0.0)
			return name + " ($" + price + ")" + "has a discount of " + discount + "%, expiry date " + expiryDate + " ("
					+ weight + "Kg), after discount price is " + price * (1 - discount) + ", after tax included ("
					+ (price * (1 - discount)) * 1.0575;
		return name + " ($" + price + ")" + "%, expiry date " + expiryDate + " (" + weight + "Kg)"
				+ ", after tax included (" + price * 1.0575;
	}

}
