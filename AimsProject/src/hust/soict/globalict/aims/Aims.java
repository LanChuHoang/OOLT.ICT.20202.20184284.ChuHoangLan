package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

public class Aims {
	
	public void test() {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		
		// Add DVDs to the cart
		anOrder.addDigitalVideoDisc(dvdList);
		// Using 
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		anOrder.addDigitalVideoDisc(dvd1, dvd2);
		
		// Display the result
		anOrder.printCart();
	}

	public static void main(String[] args) {
		// Data test
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		Store store = new Store();
		Cart cart = new Cart();
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		
		//
		mainMenu(store, cart);
	}

	public static void mainMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen = 0;
		do {
			// Print Menu
			System.out.println("\tAIMS: ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------------------------------------");
			// Check
			System.out.println("Your choice: ");
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				store.printStore();
				storeMenu(store, cart);
				break;
			}
			case '2': {
				updateMenu(store, cart);
				break;
			}
			case '3': {
				cart.printCart();
				cartMenu(store, cart);
				break;
			}
			case '0': {
				return;
			}
			default:
				System.out.println("\tInvalid");
			}
		} while (chosen != '0');
	}
	
	public static void storeMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			System.out.println("\tStore menu: ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. See a DVD's detail");
			System.out.println("2. Add a DVD to cart");
			System.out.println("3. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------------------------------------");
			// Choice
			System.out.println("Your choice: ");
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				// Input
				int id = getInputID();
				System.out.println(id);
				// Search
				DigitalVideoDisc dvd = store.searchByID(id);
				if (dvd == null) {
					System.out.println("\tNot found");
				}
				else {
					System.out.println(dvd.getDetail());
					System.out.println("Do you want to add this dvd to your cart (y/n): ");
					char chosen1 = sc.next().charAt(0);
					switch (chosen1) {
					case 'y': {
						cart.addDigitalVideoDisc(dvd);
						break;
					}
					case 'n': {
						break;
					}
					default:
						System.out.println("\tInvalid");
					}
				}
				break;
			}
			case '2': {
				// Input
				int id = getInputID();
				// Search
				DigitalVideoDisc dvd = store.searchByID(id);
				if (dvd == null) {
					System.out.println("\tNot found");
				}
				else {
					cart.addDigitalVideoDisc(dvd);
				}
				break;
			}
			case '3': {
				cart.printCart();
				cartMenu(store, cart);
				break;
			}
			case '0': {
				return;
			}
			default:
				System.out.println("\tInvalid. Try again");
			}
		} while(chosen != '0');
	}
	
	public static void updateMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			System.out.println("\tUpdate menu: ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. Add a new DVD");
			System.out.println("2. Remove a DVD");
			System.out.println("0. Back");
			System.out.println("--------------------------------------------------------------");
			// Choice
			System.out.println("Your choice: ");
			chosen = sc.next().charAt(0);
			switch (chosen) {
			case '1': {
				// Input
				System.out.println("Enter title");
				sc.nextLine();
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
				// Search for duplicate
				if (store.isContains(newDVD)) {
					System.out.println("The dvd is already in the store");
				} else {
					store.addDVD(newDVD);
				}
				break;
			}
			case '2': {
				// Input
				System.out.println("Enter ID");
				sc.nextLine();
				int id = sc.nextInt();
				// Remove
				store.removeByID(id);
				break;
			}
			case '0': {
				break;
			}
			default:
				System.out.println("\tInvalid. Try again");
			}
		} while(chosen != '0');
	}
	
	//	CART MENU
	public static void cartMenu(Store store, Cart cart) {
		Scanner sc = new Scanner(System.in);
		char chosen;
		do {
			// Print Menu
			System.out.println("\tCart menu: ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. Filter DVDs in cart");
			System.out.println("2. Sort DVDs in cart");
			System.out.println("3. Remove DVD from cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------------------------------------");
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
				removeDVDCartMenu(cart);
				break;
			}
			case '0': {
				break;
			}
			default:
				System.out.println("\tInvalid. Try again");
			}
		} while(chosen != '0');
	}
	
	public static void filterCartMenu(Cart cart) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		int chosen = sc.nextInt();
		switch (chosen) {
		case 1: {
			int id = getInputID();
			cart.searchByIDFor(id);
			break;
		}
		case 2: {
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
		int chosen = sc.nextInt();
		switch (chosen) {
		case 1: {
			cart.sortByTilteAndPrint();
			break;
		}
		case 2: {
			cart.sortByCostAndPrint();
			break;
		}
		default:
			System.out.println("\tInvalid");
		}
	}
	
	public static void removeDVDCartMenu(Cart cart) {
		// Input 
		int id = getInputID();
		cart.removeDigitalVideoDisc(id);
	}
	
	
	//
	//
	public static int getInputID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID: ");
		return sc.nextInt();
	}
	
}
