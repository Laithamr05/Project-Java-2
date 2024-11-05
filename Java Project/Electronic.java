
public class Electronic extends StockItem {
	private String version;
	private String type;
	private double power;

	public Electronic() {

	}

	public Electronic(String version, String type, double power, String brand, double discount, double price) {
		super(brand, discount, price);
		this.version = version;
		this.type = type;
		this.power = power;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return price * 1.165;
	}

	@Override
	public String toString() {

		return version + " ($" + price + ")" + "with a discount of " + discount + "% in " + type + " " + power + "Watt."
				+ " after discount price is " + price * (1 - discount) + "After discount price is "
				+ (price * (1 - discount)) + ", after tax included (" + (price * (1 - discount)) * 1.165;
	}
	

}
