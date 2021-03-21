import java.lang.reflect.Array;

public class Aims {

	public static void main(String[] args) {
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

}