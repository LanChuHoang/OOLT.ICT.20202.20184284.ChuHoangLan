package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		
		// Add DVDs to the cart
		anOrder.addMedia(dvdList);
		
		// Test
		String key = "lion";
		anOrder.searchByTitleFor(key);
	}

}
