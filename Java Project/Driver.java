//Laith Amro
//1230018
//Dr. Mamoun Nawahda
//Section 3

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

public class Driver { // the main class for managing the stock system
	public static void main(String[] args) { // the main method where we run the program
		Scanner scanner = new Scanner(System.in); // creating a new Scanner object to get input from the user
		Stock stock = new Stock("Al-Mashhadawi", new ArrayList<>()); // creating a new Stock object with the store name
																		// and an empty list of items
		stock.setLocation(new Location("Lacasa Mall", "Arehan", "Ramallah")); // setting the location of the stock

		while (true) { // looping forever until the user chooses to exit
			System.out.println("1. Load stock items from file"); // displaying the menu options
			System.out.println("2. Add a new item");
			System.out.println("3. Print expired grocery items");
			System.out.println("4. List discounted electronics");
			System.out.println("5. Sort items by brand (descending)");
			System.out.println("6. Sort items by price (descending)");
			System.out.println("7. Show items with a specific discount");
			System.out.println("8. Clone stock items");
			System.out.println("9. Exit");

			System.out.print("Enter your choice: "); // prompting the user to enter their choice
			int choice; // initializing the choice variable to store user input
			try {
				choice = Integer.parseInt(scanner.nextLine()); // reading the user's choice and converting it to an
																// integer
			} catch (NumberFormatException e) { // catching any invalid input that is not an integer
				System.out.println("Invalid choice. Please enter a number between 1 and 9.");
				continue; // if the input is invalid, we ask for a valid input again
			}

			switch (choice) { // using a switch statement to handle the user's choice
			case 1:
				System.out.print("Enter filename: "); // asking the user to provide the filename
				String filename = scanner.nextLine(); // reading the filename input
				loadItemsFromFile(stock, filename); // calling the method to load items from the file
				break;
			case 2:
				addItem(stock, scanner); // calling the addItem method to add a new item to the stock
				break;
			case 3:
				printExpiredGroceryItems(stock); // calling the method to print expired grocery items
				break;
			case 4:
				printDiscountedElectronics(stock); // calling the method to print discounted electronics
				break;
			case 5:
				sortItemsByBrand(stock); // calling the method to sort items by brand
				break;
			case 6:
				sortItemsByPrice(stock); // calling the method to sort items by price
				break;
			case 7:
				System.out.print("Enter discount to filter: "); // prompting the user to enter a discount
				try {
					double discount = Double.parseDouble(scanner.nextLine()); // reading and parsing the discount value
					printItemsWithDiscount(stock, discount); // calling the method to print items with the specified
																// discount
				} catch (NumberFormatException e) { // catching invalid input for discount
					System.out.println("Invalid discount. Please enter a valid number.");
				}
				break;
			case 8:
				cloneStockItems(stock); // calling the method to clone the stock items
				break;
			case 9:
				System.out.println("Exiting program."); // exiting the program
				return;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 9."); // handling invalid
																								// choices
			}
		}
	}

	public static void loadItemsFromFile(Stock stock, String filename) { // method to load stock items from a file
		try (Scanner fileScanner = new Scanner(new File(filename))) { // opening the file for reading
			while (fileScanner.hasNextLine()) { // looping through each line in the file
				String line = fileScanner.nextLine(); // reading the current line
				String[] parts = line.split(", "); // splitting the line into parts by comma and space

				if (parts[0].equalsIgnoreCase("Grocery")) { // if the item is a Grocery
					Calendar expiryDate = Calendar.getInstance(); // creating a Calendar object to store the expiry date
					String[] dateParts = parts[5].split("/"); // splitting the date into day, month, and year
					expiryDate.set(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]) - 1,
							Integer.parseInt(dateParts[0])); // setting the expiry date

					Grocery grocery = new Grocery(parts[1], expiryDate, Float.parseFloat(parts[6]), parts[2],
							Double.parseDouble(parts[3]), Double.parseDouble(parts[4])); // creating a new Grocery
																							// object
					stock.addStockItem(grocery); // adding the grocery item to the stock
				} else if (parts[0].equalsIgnoreCase("Electronics")) { // if the item is Electronics
					Electronic electronic = new Electronic(parts[1], parts[5], Double.parseDouble(parts[6]), parts[2],
							Double.parseDouble(parts[3]), Double.parseDouble(parts[4])); // creating a new Electronic
																							// object
					stock.addStockItem(electronic); // adding the electronic item to the stock
				} else {
					System.out.println("Unknown item type in line: " + line); // if the item type is not recognized
				}
			}
			System.out.println("Items loaded from file."); // confirming that items have been loaded
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename); // handling file not found error
		} catch (Exception e) {
			System.out.println("Error reading file: " + e.getMessage()); // handling any other errors while reading the
																			// file
		}
	}

	public static void addItem(Stock stock, Scanner scanner) { // method to add a new item to the stock
		System.out.print("Enter item details: "); // asking the user for item details
		String[] parts = scanner.nextLine().split(", "); // splitting the input into parts by comma and space
		try {
			if (parts[0].equalsIgnoreCase("Grocery")) { // if the item is a Grocery
				Calendar expiryDate = Calendar.getInstance(); // creating a Calendar object for expiry date
				String[] dateParts = parts[5].split("/"); // splitting the expiry date
				expiryDate.set(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]) - 1,
						Integer.parseInt(dateParts[0])); // setting the expiry date

				Grocery grocery = new Grocery(parts[1], expiryDate, Float.parseFloat(parts[6]), parts[2],
						Double.parseDouble(parts[3]), Double.parseDouble(parts[4])); // creating a Grocery item
				stock.addStockItem(grocery); // adding the grocery item to the stock
				System.out.println("Grocery item added."); // confirming item is added
			} else if (parts[0].equalsIgnoreCase("Electronics")) { // if the item is Electronics
				Electronic electronic = new Electronic(parts[1], parts[5], Double.parseDouble(parts[6]), parts[2],
						Double.parseDouble(parts[3]), Double.parseDouble(parts[4])); // creating an Electronic item
				stock.addStockItem(electronic); // adding the electronic item to the stock
				System.out.println("Electronic item added."); // confirming item is added
			} else {
				System.out.println("Invalid item type. Please start with 'Grocery' or 'Electronics'."); // if the item
																										// type is
																										// invalid
			}
		} catch (Exception e) {
			System.out.println("Invalid input format for item."); // catching any error while adding item
		}
	}

	public static void printExpiredGroceryItems(Stock stock) { // method to print expired grocery items
		Calendar today = Calendar.getInstance(); // getting the current date
		for (int i = 0; i < stock.getItems().size(); i++) { // looping through each item in the stock
			StockItem item = stock.getItems().get(i); // getting the current item
			if (item instanceof Grocery) { // if the item is a Grocery
				Grocery grocery = (Grocery) item; // casting the item to a Grocery
				if (grocery.getExpiryDate().before(today)) { // checking if the item is expired
					System.out.println(grocery); // printing the expired grocery item
				}
			}
		}
	}

	public static void printDiscountedElectronics(Stock stock) { // method to print discounted electronics
		for (int i = 0; i < stock.getItems().size(); i++) { // looping through each item in the stock
			StockItem item = stock.getItems().get(i); // getting the current item
			if (item instanceof Electronic) { // if the item is an Electronic
				Electronic electronic = (Electronic) item; // casting the item to an Electronic
				if (electronic.getDiscount() > 0) { // if
					// the item has a discount
					System.out.println(electronic); // printing the discounted electronic item
				}
			}
		}
	}

	public static void sortItemsByBrand(Stock stock) { // method to sort items by brand in descending order
		stock.getItems().sort(Comparator.comparing(StockItem::getBrand).reversed()); // sorting by brand in descending
																						// order
		System.out.println("Items sorted by brand (descending)."); // confirming sort operation
	}

	public static void sortItemsByPrice(Stock stock) { // method to sort items by price in descending order
		stock.getItems().sort(Comparator.comparing(StockItem::getPrice).reversed()); // sorting by price in descending
																						// order
		System.out.println("Items sorted by price (descending)."); // confirming sort operation
	}

	public static void printItemsWithDiscount(Stock stock, double discount) { // method to print items with a specific
																				// discount
		for (int i = 0; i < stock.getItems().size(); i++) { // looping through each item in the stock
			StockItem item = stock.getItems().get(i); // getting the current item
			if (item.getDiscount() == discount) { // if the item has the specified discount
				System.out.println(item); // printing the item
			}
		}
	}

	public static void cloneStockItems(Stock stock) { // method to clone stock items
		ArrayList<StockItem> clonedItems = new ArrayList<>(stock.getItems()); // cloning the stock items
		System.out.println("Stock items cloned:"); // message confirming cloning
		for (int i = 0; i < clonedItems.size(); i++) { // looping through cloned items
			System.out.println(clonedItems.get(i)); // printing each cloned item
		}
	}

}
