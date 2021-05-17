package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.interfaces.Playable;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.cd.CompactDisc;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.MainFrame;
import hust.soict.globalict.aims.screen.cart.CartScreen;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

import javax.swing.JFrame;

public class Aims {
		
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void initializeDataTest() {
		// Create 6 new items
		Book book1 = new Book("Harry Potter1", "Fantasy", 11.5f, "Author 5", "Author 6");
		Book book2 = new Book("Harry Potter2", "Fantasy", 11.6f, "Author 3", "Author 4");
		Book book3 = new Book("Harry Potter3", "Fantasy", 11.7f, "Author 1", "Author 2");
		Book book4 = new Book("Harry Potter4", "Fantasy", 11.5f, "Author 5", "Author 6");
		Book book5 = new Book("Harry Potter5", "Fantasy", 11.6f, "Author 3", "Author 4");
		Book book6 = new Book("Harry Potter6", "Fantasy", 11.7f, "Author 1", "Author 2");
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
		Media[] newMedia = {book3, book2, book1, book4, book5, book6, dvd3, dvd2, dvd1, cd3, cd2, cd1}; 
		cart.addMedia(newMedia);
		store.addMedia(newMedia);
	}
	
	public static void main(String[] args) {
		initializeDataTest();
		CartScreen cartWindow = new CartScreen(store, cart, false);
		MainFrame storeWindow = new MainFrame(store, cart, false);
		
		cartWindow.getController().setStoreWindow(storeWindow);
		storeWindow.setCartWindow(cartWindow);
		
		storeWindow.setVisible(true);
	}
		

	// CART MENU
	public static void printCartMenu() {
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
			printCartMenu();
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
				System.out.println(searchItem.toString());
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
			System.out.println("Sort by title and cost: ");
			cart.sortByTitleAndCost();
			cart.printCart();
			break;
		}
		case '2': {
			System.out.println("Sort by cost and title: ");
			cart.sortByCostAndTitle();
			cart.printCart();
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
