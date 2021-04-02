package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	// Display 
	public void printCart() {
		System.out.println("*******************************CART*******************************");
		if (qtyOrdered <= 0) {
			System.out.println("The cart is empty");
		} else {
			for(int i = 0; i < qtyOrdered; ++i) {
				System.out.print((i+1) +  ".");
				System.out.print(itemsOrdered[i].getDetail());
				System.out.println();
			}
			System.out.println("Total cost: " + totalCost());
		}
		System.out.println("******************************************************************");
	}
	
	// Checking + Searching
	public boolean isFull() {
		return qtyOrdered >= MAX_NUMBERS_ORDERED;
	}
	
	public void searchByIDFor(int id) {
		System.out.println("Search for " + id);
		for(int i = 0; i < qtyOrdered; ++i) {
			if(itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].getDetail());
				return;
			}
		}
		System.out.println("Cannot found");
	}
	
	public void searchByTitleFor(String key) {
		boolean isFound = false;
		if (key != null) {
			for(int i = 0; i < qtyOrdered; ++i) {
				DigitalVideoDisc dvd = itemsOrdered[i];
				if (dvd.titleContains(key)) {
					System.out.println(dvd.getDetail());
					isFound = true;
				}
			}
		}
		if(!isFound) {
			System.out.println("\tNot Found");
		}
	}
	
	// Sorting
	public void sortByCostAndPrint() {
		System.out.println("Sorted by cost");
		itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
		printCart();
	}
	
	public void sortByTilteAndPrint() {
		System.out.println("Sorted by tilte");
		DVDUtils.sortByTitle(itemsOrdered);
		printCart();
	}
	
	public void sortAndPrint() {
		System.out.println("Sorted");
		for(int i = 0; i < qtyOrdered; ++i) {
			for(int j = i + 1; j < qtyOrdered; ++j) {				
				float costJ = itemsOrdered[j].getCost();
				float costI = itemsOrdered[i].getCost();
				int lengthJ = itemsOrdered[j].getLength();
				int lengthI = itemsOrdered[i].getLength();
				int titleCompareResult = DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]);
				
				if(titleCompareResult == 1 || (titleCompareResult == 0 && costJ > costI) || (titleCompareResult == 0 && costJ == costI && lengthJ > lengthI)) {
					DigitalVideoDisc temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;
				}
			}
		}
		printCart();
	}
	
	// Add DVDs
		// Add 1 DVD
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (!isFull()) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc \"" + disc.getTitle() +"\" has been added successfully. You can use printCart method to view the result.");
		} else {
			System.out.println("The cart is full. Please remove some items to add new one");
		}
	}
	
		// Add 2 DVDs
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc[] newList = {dvd1, dvd2};
		addDigitalVideoDisc(newList);
	}
	
		// Add a list of DVDs
		//--> It's can run correctly. If you want to test it, please comment the "Add an arbitrary number of DVDs" method below.
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int numNewDisc = dvdList.length;
		if (qtyOrdered + numNewDisc <= MAX_NUMBERS_ORDERED) {
			for(int i = 0; i < numNewDisc; ++i) {
				addDigitalVideoDisc(dvdList[i]);
			}
		} else {
			System.out.println("Your cart can only add up to " + (MAX_NUMBERS_ORDERED - qtyOrdered) + " more products.");
		}
	}
	*/
	
		// Add an arbitrary number of DVDs
	public void addDigitalVideoDisc(DigitalVideoDisc... argsDiscs) {
		int numNewDisc = argsDiscs.length;
		if (qtyOrdered + numNewDisc <= MAX_NUMBERS_ORDERED) {
			for(int i = 0; i < numNewDisc; ++i) {
				addDigitalVideoDisc(argsDiscs[i]);
			}
		} else {
			System.out.println("Your cart can only add up to " + (MAX_NUMBERS_ORDERED - qtyOrdered) + " more products.");
		}
	}
		
	// Remove DVDs
	public void removeDigitalVideoDisc(int id) {
		for(int i = 0; i < qtyOrdered; ++i) {
			if(itemsOrdered[i].getId() == id) {
				for(int j = i; j < qtyOrdered-1; ++j) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered-1] = null;
				qtyOrdered--;
				System.out.println("The disc has been removed successfully.  You can use printCart method to view the result.");
				return;
			}
		}
		System.out.println("Cannot found the disc");
	}
	
	// Calculating
	public float totalCost() {
		float total = 0;
		for(int i=0; i<qtyOrdered; ++i) {
			float disCost = itemsOrdered[i].getCost();
			total += disCost;
		}
		return total;
	}
}
