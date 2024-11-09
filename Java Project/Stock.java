
//Laith Amro
//1230018
//Dr. Mamoun Nawahda
//Section 3
import java.util.ArrayList;

public class Stock { // Stock class for managing stock items
	private String name; // stock name
	private Location location; // location where stock is held
	private ArrayList<StockItem> items = new ArrayList<>(); // list of stock items

	public Stock() { // default constructor
	}

	public Stock(String name, ArrayList<StockItem> items) { // constructor to set stock name and items list
		this.name = name; // setting the stock name
		this.items = items; // setting the items list
	}

	public ArrayList<StockItem> getItems() { // getter for items list
		return items;
	}

	public void setItem(ArrayList<StockItem> item) { // setter to update the items list
		this.items = item;
	}

	public int countElectronic() { // method to count electronics in stock
		int count = 0;
		for (Object obj : items) { // loop through items
			if (obj instanceof Electronic) { // check if item is of type Electronic
				count++; // increment count if electronic
			}
		}
		return count; // return count of electronics
	}

	public int countGrocery() { // method to count groceries in stock
		int count = 0;
		for (Object obj : items) { // loop through items
			if (obj instanceof Grocery) { // check if item is of type Grocery
				count++; // increment count if grocery
			}
		}
		return count; // return count of groceries
	}

	public String getName() { // getter for stock name
		return name;
	}

	public void setName(String name) { // setter to update stock name
		this.name = name;
	}

	public Location getLocation() { // getter for location
		return location;
	}

	public void setLocation(Location location) { // setter to update location
		this.location = location;
	}

	public void addStockItem(StockItem stock) { // method to add item to stock
		items.add(stock); // add stock item to the list
	}

	@Override
	public String toString() { // method to convert stock info to string
		return "Stock Name: " + name + "\n" + "Location: " + location + "\n" + "Item: " + items; // returning formatted
																									// string
	}

}
