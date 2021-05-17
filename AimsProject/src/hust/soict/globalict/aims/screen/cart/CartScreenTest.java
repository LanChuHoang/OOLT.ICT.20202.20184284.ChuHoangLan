package hust.soict.globalict.aims.screen.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.cd.CompactDisc;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.MainFrame;
import hust.soict.globalict.aims.store.Store;

public class CartScreenTest {
	
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

}
