import java.util.ArrayList;

public class Stock {
	private String name;
	private Location location;
	private ArrayList<StockItem> items = new ArrayList<>();

	public Stock() {

	}

	public Stock(String name, ArrayList<StockItem> items) {
		this.name = name;
		this.items = items;
	}

	public ArrayList<StockItem> getItems() {
		return items;
	}

	public void setItem(ArrayList<StockItem> item) {
		this.items = item;
	}

	public int countElectronic() {
		int count = 0;
		for (Object obj : items) {
			if (obj instanceof Electronic) {
				count++;
			}
		}
		return count;
	}

	public int countGrocery() {
		int count = 0;
		for (Object obj : items) {
			if (obj instanceof Grocery) {
				count++;
			}
		}
		return count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void addStockItem(StockItem stock) {
		items.add(stock);
	}

	@Override
	public String toString() {
		return "Stock Name: " + name + "\n" + "Location: " + location + "\n" + "Item: " + items;
	}

}
