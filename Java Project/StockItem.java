
public class StockItem implements Comparable {
	protected String brand;
	protected double discount;
	protected double price;

	public StockItem() {

	}

	public StockItem(String brand, double discount, double price) {
		super();
		this.brand = brand;
		this.discount = discount;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double calculateTax() {
		return calculateTax();
	}

	@Override
	public String toString() {
		if (discount > 0.0)
			return brand + " ($" + price + ")" + "has a discount of " + discount * 100 + "%.";
		return brand + " ($" + price + ").";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StockItem))
			return false;
		return ((StockItem) obj).brand == this.brand && ((StockItem) obj).discount == this.discount
				&& ((StockItem) obj).price == this.price;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
