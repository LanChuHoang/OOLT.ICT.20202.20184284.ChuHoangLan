package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.cd.CompactDisc;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

public class Aims {
	public static void initializeDataTest(Store store) {
		// Create 6 new items
		Book book1 = new Book("Harry Potter1", "Fantasy", 11.5f, "Author 5", "Author 6");
		Book book2 = new Book("Harry Potter2", "Fantasy", 11.6f, "Author 3", "Author 4");
		Book book3 = new Book("Harry Potter3", "Fantasy", 11.7f, "Author 1", "Author 2");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		CompactDisc cd1 = new CompactDisc("Album1", "Ballad", 10.5f, "Chullee", "artist1");
		CompactDisc cd2 = new CompactDisc("Album2", "Ballad", 10.6f, "Chullee", "artist2");
		CompactDisc cd3 = new CompactDisc("Album3", "Ballad", 10.7f, "Chullee", "artist3");
		Track song1 = new Track("It's you", 333);
		Track song2 = new Track("Better", 1173);
		cd1.addTrack(song1, song2);
		// Add the items to the store
		Media[] newMedia = {book3, book2, book1, dvd3, dvd2, dvd1, cd3, cd2, cd1}; 
		store.addMedia(newMedia);
	}
	
	public static void main(String[] args) {
		// Data test
		Store store = new Store();
		Cart cart = new Cart();
		initializeDataTest(store);
		
		// Run the main menu
		MemoryDaemon memoryDaemon = new MemoryDaemon();
		Thread thread = new Thread(memoryDaemon);
		thread.setDaemon(true);
		thread.start();
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
		char choice;
		do {
			// Print Menu
			printMainMenu();
			// Check
			choice = sc.next().charAt(0);
			switch (choice) {
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
				return;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while (choice != '0');
	}

	// STORE MENU
	public static void printStoreMenu(Store store) {
		System.out.println("----------------------------------STORE--------------------------------");
		store.printStore();
		System.out.println("Options: ");
		System.out.println("1. View media's details");
		System.out.println("2. Add media to cart");
		System.out.println("3. Play an item");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("\tYour choice: ");
	}
	
	public static void storeMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			// Print Menu
			printStoreMenu(store);
			// Choice
			choice = sc.next().charAt(0);
			switch (choice) {
			case '1': {
				addMediaFromStoreToCart(store, cart);
				break;
			}
			case '2': {
				addMediaFromStoreToCart(store, cart);
				break;
			}
			case '3': {
				int chosenID = getInputID();
				Media chosenItem = store.searchByID(chosenID);
				if (chosenItem == null) {
					System.out.println("Cannot found");
				} else if (chosenItem instanceof Playable) {
					((Playable) chosenItem).play();
				} else {
					System.out.println("This item is not playable");
				}
				break;
			}
			case '4': {
				cartMenu(store, cart);
				break;
			}
			case '0': {
				return;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while(choice != '0');
	}
	
	public static void addMediaFromStoreToCart(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		// Search for the chosen item
		int id = getInputID();
		Media chosenItem = store.searchByID(id);
		if (chosenItem == null) {
			System.out.println("\tCannot found");
		}
		else {
			// Print the found item
			System.out.println(chosenItem.getDetail());
			// Ask the user for adding the chosen item to the current cart
			System.out.println("Do you want to add this item to your cart (y/n): ");
			char userChoice = sc.next().charAt(0);
			switch (userChoice) {
			case 'y': {
				cart.addMedia(chosenItem);
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
	
	// UPDATE STORE MENU
	public static void printUpdateMenu() {
		System.out.println("-------------------------------UPDATE STORE----------------------------");
		System.out.println("Options: ");
		System.out.println("1. Add a new item");
		System.out.println("2. Remove an item");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("\tYour choice: ");
	}
	
	public static void updateMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			// Print Menu
			printUpdateMenu();
			// Choice
			choice = sc.next().charAt(0);
			switch (choice) {
			case '1': {
				addNewMediaToStore(store);
			}
			case '2': {
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
		} while(choice != '0');
	}
	
	public static void addNewMediaToStore(Store store) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			// Print Menu
			System.out.println("1. Book");
			System.out.println("2. DVD");
			System.out.println("3. CD");
			System.out.println("0. Exit");
			// Choice
			choice = sc.next().charAt(0);
			switch (choice) {
			case '1': {
				Book newBook = getInputBook();
				store.addMedia(newBook);
				break;
			}
			case '2': {
				DigitalVideoDisc newDVD = getInputDVD();
				store.addMedia(newDVD);
				break;
			}
			case '3': {
				CompactDisc newCD = getInputCD();
				store.addMedia(newCD);
				break;
			}
			case '0': {
				break;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while(choice != '0');
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
	
	public static DigitalVideoDisc getInputDVD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title");
		String title = sc.nextLine();
		System.out.println("Enter Category");
		String category = sc.nextLine();
		System.out.println("Enter Director");
		String director = sc.nextLine();
		System.out.println("Enter Length");
		int length = sc.nextInt();
		System.out.println("Enter Cost");
		float cost = sc.nextFloat();
		// Create a new DVD
		DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
		return newDVD;
	}
	
	public static CompactDisc getInputCD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title");
		String title = sc.nextLine();
		System.out.println("Enter Category");
		String category = sc.nextLine();
		System.out.println("Enter Cost");
		float cost = sc.nextFloat();
		System.out.println("Enter Director");
		String director = sc.nextLine();
		System.out.println("Enter Artist");
		String artist = sc.nextLine();
		
		// Create a new CD
		CompactDisc newCD = new CompactDisc(title, category, cost, director, artist);
		return newCD;
	}
	
	// CART MENU
	public static void printCartMenu(Cart cart) {
		System.out.println("----------------------------------CART---------------------------------");
		cart.printCart();
		System.out.println("Options: ");
		System.out.println("1. Filter items in cart");
		System.out.println("2. Sort items in cart");
		System.out.println("3. Remove an item from cart");
		System.out.println("4. Play an item");
		System.out.println("5. Get lucky item from cart");
		System.out.println("6. Place order");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("\tYour choice: ");
	}
	
	public static void cartMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			// Print Menu
			printCartMenu(cart);
			// Choice
			choice = sc.next().charAt(0);
			switch (choice) {
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
				int chosenID = getInputID();
				Media chosenItem = cart.searchByID(chosenID);
				if (chosenItem == null) {
					System.out.println("Cannot found");
				} else if (chosenItem instanceof Playable) {
					((Playable) chosenItem).play();
				} else {
					System.out.println("This item is not playable");
				}
				break;
			}
			case '5': {
				cart.getLuckyItem();
				break;
			}
			case '6': {
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
		} while(choice != '0');
	}
	
	public static void filterCartMenu(Cart cart) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		char choice = sc.next().charAt(0);
		switch (choice) {
		case '1': {
			int id = getInputID();
			Media searchItem = cart.searchByID(id);
			if(searchItem == null) {
				System.out.println("Cannot found");
			} else {
				System.out.println(searchItem.getDetail());
			}
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

}
