
public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOdrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		
		anOdrder.addDigitalVideoDisc(dvd1);
		anOdrder.addDigitalVideoDisc(dvd2);
		anOdrder.addDigitalVideoDisc(dvd3);
		
		// Print total cost
		System.out.println("The total cost is: " + anOdrder.totalCost());
		anOdrder.printCart();
		System.out.println();
		
		anOdrder.removeDigitalVideoDisc(dvd3);
		anOdrder.printCart();
		System.out.println();
	}

}
