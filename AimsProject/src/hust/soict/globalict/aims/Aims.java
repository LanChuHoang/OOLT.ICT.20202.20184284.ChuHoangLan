package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

public class Aims {
	
	public static void main(String[] args) {
		// Data test
		Store store = new Store();
		Cart cart = new Cart();
		// Create 6 new items
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		Book book3 = new Book("Harry Potter3", "Fantasy", 11.7f, "Author 1", "Author 2");
		Book book2 = new Book("Harry Potter2", "Fantasy", 11.6f, "Author 3", "Author 4");
		Book book1 = new Book("Harry Potter1", "Fantasy", 11.5f, "Author 5", "Author 6");
		// Add the items to the store
		Media[] newMedia = {dvd3, dvd2, dvd1, book3, book2, book1}; 
		store.addMedia(newMedia);;
		
		// Run the main menu
		mainMenu(store, cart);
	}
	
	// MAIN MENU
	public static void printMainMenu() {
		System.out.println("*******************************MAIN MENU*******************************");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("***********************************************************************");
		System.out.println("\tYour choice: ");
	}
	
	public static void mainMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			printMainMenu();
			// Check
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				storeMenu(store, cart);
				break;
			}
			case '2': {
				updateMenu(store, cart);
				break;
			}
			case '3': {
				cartMenu(store, cart);
				break;
			}
			case '0': {
				sc.close();
				return;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while (chosen != '0');
		sc.close();
	}

	// STORE MENU
	public static void printStoreMenu(Store store) {
		System.out.println("----------------------------------STORE--------------------------------");
		store.printStore();
		System.out.println("Options: ");
		System.out.println("1. View media's details");
		System.out.println("2. Add media to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("\tYour choice: ");
	}
	
	public static void storeMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			printStoreMenu(store);
			// Choice
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				addMediaFromStoreToCart(store, cart);
				break;
			}
			case '2': {
				addMediaFromStoreToCart(store, cart);
				break;
			}
			case '3': {
				cartMenu(store, cart);
				break;
			}
			case '0': {
				return;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while(chosen != '0');
	}
	
	public static void addMediaFromStoreToCart(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		// Search
		int id = getInputID();
		Media item = store.searchByID(id);
		if (item == null) {
			System.out.println("\tCannot found");
		}
		else {
			if (item instanceof DigitalVideoDisc) {
				System.out.println(((DigitalVideoDisc)item).getDetail());
			} else if (item instanceof Book) {
				System.out.println(((Book)item).getDetail());
			} else {
				System.out.println("\tDowncasting error");
			}
			//sc.nextLine();
			System.out.println("Do you want to add this dvd to your cart (y/n): ");
			char chosen = sc.next().charAt(0);
			switch (chosen) {
			case 'y': {
				cart.addMedia(item);
				break;
			}
			case 'n': {
				break;
			}
			default:
				System.out.println("\tInvalid");
			}
		}
	}
	
	// UPDATE MENU
	public static void printUpdateMenu() {
		System.out.println("-------------------------------UPDATE STORE----------------------------");
		System.out.println("Options: ");
		System.out.println("1. Add a new dvd");
		System.out.println("2. Add a new book");
		System.out.println("3. Remove an item");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("\tYour choice: ");
	}
	
	public static void updateMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			printUpdateMenu();
			// Choice
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				// Input
				DigitalVideoDisc newDVD = getInputDVD();
				// Search for duplicate
				if (store.contains(newDVD)) {
					System.out.println("The dvd is already in the store");
				} else {
					store.addMedia(newDVD);
				}
				break;
			}
			case '2': {
				// Input
				Book newBook = getInputBook();
				// Search for duplicate
				if (store.contains(newBook)) {
					System.out.println("The book is already in the store");
				} else {
					store.addMedia(newBook);
				}
				break;
			}
			case '3': {
				int id = getInputID();
				store.removeMedia(id);
				break;
			}
			case '0': {
				break;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while(chosen != '0');
	}
	
	// CART MENU
	public static void printCartMenu(Cart cart) {
		System.out.println("----------------------------------CART---------------------------------");
		cart.printCart();
		System.out.println("Options: ");
		System.out.println("1. Filter items in cart");
		System.out.println("2. Sort items in cart");
		System.out.println("3. Remove an item from cart");
		System.out.println("4. Get lucky item from cart");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("\tYour choice: ");
	}
	
	public static void cartMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			printCartMenu(cart);
			// Choice
			System.out.println("Your choice: ");
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				filterCartMenu(cart);
				break;
			}
			case '2': {
				sortCartMenu(cart);
				break;
			}
			case '3': {
				int id = getInputID();
				cart.removeMedia(id);
				break;
			}
			case '4': {
				cart.getLuckyItem();
				break;
			}
			case '5': {
				System.out.println("Your order has been created");
				cart.emptyCart();
				break;
			}
			case '0': {
				break;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while(chosen != '0');
	}
	
	public static void filterCartMenu(Cart cart) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		char chosen = sc.next().charAt(0);
		switch (chosen) {
		case '1': {
			int id = getInputID();
			cart.searchByIDFor(id);
			break;
		}
		case '2': {
			System.out.println("Enter title");
			sc.nextLine();
			String title = sc.nextLine();
			cart.searchByTitleFor(title);
			break;
		}
		default:
			System.out.println("\tInvalid");
		}
	}	
	
	public static void sortCartMenu(Cart cart) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		char chosen = sc.next().charAt(0);
		switch (chosen) {
		case '1': {
			cart.sortByTilteAndPrint();
			break;
		}
		case '2': {
			cart.sortByCostAndPrint();
			break;
		}
		default:
			System.out.println("\tInvalid");
		}
	}
	
	
	//
	//
	public static int getInputID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int inputID = sc.nextInt();
		return inputID;
	}
	
	public static DigitalVideoDisc getInputDVD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title");
		String title = sc.nextLine();
		System.out.println("Enter Category");
		String category = sc.nextLine();
		System.out.println("Enter Directory");
		String directory = sc.nextLine();
		System.out.println("Enter Length");
		int length = sc.nextInt();
		System.out.println("Enter Cost");
		float cost = sc.nextFloat();
		// Create a new dvd
		DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, directory, length, cost);
		return newDVD;
	}
	
	public static Book getInputBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title");
		String title = sc.nextLine();
		System.out.println("Enter Category");
		String category = sc.nextLine();
		System.out.println("Enter Author");
		String author = sc.nextLine();
		System.out.println("Enter Cost");
		float cost = sc.nextFloat();
		// Create a new book
		Book newBook = new Book(title, category, cost, author);
		return newBook;
	}
	
}
