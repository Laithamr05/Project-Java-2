import java.io.*;
import java.util.*;

public class StockDriver {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Stock stock = new Stock("Al-Mashhadawi", new ArrayList<>());
		stock.setLocation(new Location("Lacasa Mall", "Arehan", "Ramallah"));

		System.out.println("1. Load stock items from file");
		System.out.println("2. Add a new item");
		System.out.println("3. Print expired grocery items");
		System.out.println("4. List discounted electronics");
		System.out.println("5. Sort items by brand (descending)");
		System.out.println("6. Sort items by price (descending)");
		System.out.println("7. Show items with a specific discount");
		System.out.println("8. Clone stock items");

		int choice = scanner.nextInt();
		switch (choice) {
		case 1 -> loadItemsFromFile(stock, "data.txt");
		case 2 -> addItem(stock, scanner);
		case 3 -> printExpiredGroceryItems(stock);
		case 4 -> printDiscountedElectronics(stock);
		case 5 -> sortItemsByBrand(stock);
		case 6 -> sortItemsByPrice(stock);
		case 7 -> {
			System.out.print("Enter discount to filter: ");
			double discount = scanner.nextDouble();
			printItemsWithDiscount(stock, discount);
		}
		case 8 -> cloneStockItems(stock);
		default -> System.out.println("Invalid choice");
		}
	}

	public static void loadItemsFromFile(Stock stock, String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(", ");
				if (parts[0].equalsIgnoreCase("Grocery")) {
					// Parsing grocery item
					Calendar expiryDate = Calendar.getInstance();
					expiryDate.set(Integer.parseInt(parts[5].split("/")[2]),
							Integer.parseInt(parts[5].split("/")[1]) - 1, Integer.parseInt(parts[5].split("/")[0]));
					stock.addStockItem(new Grocery(parts[1], expiryDate, Float.parseFloat(parts[6]), parts[2],
							Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
				} else if (parts[0].equalsIgnoreCase("Electronics")) {
					// Parsing electronic item
					stock.addStockItem(new Electronic(parts[1], parts[5], Double.parseDouble(parts[6]), parts[2],
							Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
				}
			}
			System.out.println("Items loaded from file.");
		} catch (IOException e) {
			System.out.println("Error loading file: " + e.getMessage());
		}
	}

	public static void addItem(Stock stock, Scanner scanner) {
		System.out.println("Add new item: 1 for Grocery, 2 for Electronics");
		int itemType = scanner.nextInt();
		scanner.nextLine(); // consume newline
		if (itemType == 1) {
			System.out.print("Enter Grocery details (name, brand, discount, price, expiry date dd/mm/yyyy, weight): ");
			String[] parts = scanner.nextLine().split(", ");
			Calendar expiryDate = Calendar.getInstance();
			String[] dateParts = parts[4].split("/");
			expiryDate.set(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]) - 1,
					Integer.parseInt(dateParts[0]));
			stock.addStockItem(new Grocery(parts[0], expiryDate, Float.parseFloat(parts[5]), parts[1],
					Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
		} else if (itemType == 2) {
			System.out.print("Enter Electronic details (version, type, power, brand, discount, price): ");
			String[] parts = scanner.nextLine().split(", ");
			stock.addStockItem(new Electronic(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3],
					Double.parseDouble(parts[4]), Double.parseDouble(parts[5])));
		}
		System.out.println("Item added.");
	}

	public static void printExpiredGroceryItems(Stock stock) {
		Calendar today = Calendar.getInstance();
		for (StockItem item : stock.getItems()) {
			if (item instanceof Grocery) {
				Grocery grocery = (Grocery) item;
				if (grocery.getExpiryDate().before(today)) {
					System.out.println(grocery);
				}
			}
		}
	}

	public static void printDiscountedElectronics(Stock stock) {
		for (StockItem item : stock.getItems()) {
			if (item instanceof Electronic) {
				Electronic electronic = (Electronic) item;
				if (electronic.getDiscount() > 0) {
					System.out.println("Brand: " + electronic.getBrand() + ", Type: " + electronic.getType()
							+ ", Price after discount: " + electronic.getPrice() * (1 - electronic.getDiscount()));
				}
			}
		}
	}

	public static void sortItemsByBrand(Stock stock) {
		stock.getItems().sort((a, b) -> b.getBrand().compareTo(a.getBrand()));
		System.out.println("Items sorted by brand (descending):");
		stock.getItems().forEach(System.out::println);
	}

	public static void sortItemsByPrice(Stock stock) {
		stock.getItems().sort(Comparator.comparingDouble(StockItem::getPrice).reversed());
		System.out.println("Items sorted by price (descending):");
		stock.getItems().forEach(System.out::println);
	}

	public static void printItemsWithDiscount(Stock stock, double discount) {
		for (StockItem item : stock.getItems()) {
			if (item.getDiscount() == discount) {
				System.out.println(item);
			}
		}
	}

	public static void cloneStockItems(Stock stock) {
		ArrayList<StockItem> clonedItems = new ArrayList<>(stock.getItems());
		System.out.println("Stock items cloned.");
		clonedItems.forEach(System.out::println);
	}
}
