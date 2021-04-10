package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter", "a", "a", 1, 0.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Harry Potter", "a", "a", 2, 0.2f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Harry Potter", "a", "a", 2, 0.3f);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6};
		
		// Add DVDs to the cart
		anOrder.addMedia(dvdList);
		
		// Print
		anOrder.printCart();
		
		// Sort
		anOrder.sortByCostAndPrint();
		anOrder.sortByTilteAndPrint();
		anOrder.sortByTitleAndCost();
		
		// Search
		anOrder.searchByID(6);
		anOrder.searchByID(0);

	}

}
