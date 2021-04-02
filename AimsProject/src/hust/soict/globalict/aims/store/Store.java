package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Store {
	public static final int CAPACITY = 20;
	public int numItems;
	public DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[CAPACITY];
	
	// Checking
	public boolean isEmpty() {
		return numItems == 0;
	}
	
	public boolean isFull() {
		return numItems == CAPACITY;
	}
	
	public boolean isContains(DigitalVideoDisc dvd) {
		String inputTitle = dvd.getTitle();
		String inputDirector = dvd.getDirector();
		for (int i = 0; i < numItems; ++i) {
			String title = itemsInStore[i].getTitle();
			String director = itemsInStore[i].getDirector();
			if (title.equals(inputTitle) && director.equals(inputDirector)) {
				return true;
			}
		}
		return false;
	}
	
	// Searching 
	public DigitalVideoDisc searchByID(int id) {
		for(int i = 0; i < numItems; ++i) {
			if (itemsInStore[i].getId() == id) {
				return itemsInStore[i];
			}
		}
		return null;
	}
	
	
	//
	//
	
	// Display
	public void printStore() {
		if (isEmpty()) {
			System.out.println("\tThe store is empty");
		} else {
			System.out.println("Items in store: ");
			System.out.println("--------------------------------------------");
			for (int i = 0; i < numItems; ++i) {
				System.out.println((i+1) + ".DVD: " + itemsInStore[i].getShortDetail());
				
			}
			System.out.println("--------------------------------------------");
		}
	}
	
	// Update
	public void addDVD(DigitalVideoDisc dvd) {
		if (isFull()) {
			System.out.println("\tThe store is full");
		} else {
			if (dvd == null) {
				System.out.println("\tDVD input is null");
			}
			itemsInStore[numItems] = dvd;
			numItems++;
			System.out.println("Added " + itemsInStore[numItems - 1].getShortDetail());
		}
	}
	
	public void removeByID(int id) {
		for(int i = 0; i < numItems; ++i) {
			if (itemsInStore[i].getId() == id) {
				String delDetail = itemsInStore[i].getShortDetail();
				for (int j = i; j < numItems-1; ++j) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				itemsInStore[numItems] = null;
				numItems--;
				System.out.println("Deleted " + delDetail);
				return;
			}
		}
		// If no item matched
		System.out.println("\tNot Found");
	}
	
}
