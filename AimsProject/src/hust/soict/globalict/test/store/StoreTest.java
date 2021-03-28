package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
		
		Store store = new Store();
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		store.removeByID(4);
		store.printStore();
	}

}
