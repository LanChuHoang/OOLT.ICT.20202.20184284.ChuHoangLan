package hust.soict.globalict.aims.cart;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.book.Book;
import hust.soict.globalict.aims.media.disc.dvd.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.MediaUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private boolean hasLuckyNumber = false;
	
	// Update
	public void addMedia(Media...newMediaList) {
		for (Media newMedia : newMediaList) {
			if (this.isFull()) {
				System.out.println("The cart is full. Cannot add more media");
				return;
			} else {
				if (newMedia == null) {
					System.out.println("The new media is null");
				} else {
					itemsOrdered.add(newMedia);
					System.out.println("Added " + newMedia.getTitle() + " to the Cart");
				}
			}
		}
	}
	
	public void removeMedia(int id) {
		for (Media item : itemsOrdered) {
			if (item.getId() == id) {
				itemsOrdered.remove(item);
				System.out.println("Removed " + id + " from the Cart");
				return;
			}
		}
		System.out.println("Cannot Found");
		
	}
	
	public void emptyCart() {
		itemsOrdered = new ArrayList<Media>();
		hasLuckyNumber = false;
	}
	
	// Display 
	public void printCart() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("\tThe Cart is empty");
		} else {
			int i = 0;
			for(Media item : itemsOrdered) {
				if (item instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc)item;
					System.out.println("\t" + (i+1) + ". " + dvd.getDetail());
				} else if (item instanceof Book) {
					Book book = (Book)item;
					System.out.println("\t" + (i+1) + ". " + book.getDetail());
				} else {
					System.out.println("\tDowncasting error");
				}
				i++;
			}
			System.out.println("\tTotal cost: " + totalCost() + " $");
		}
	}
	
	// Checking + Searching
	public boolean isFull() {
		return itemsOrdered.size() >= MAX_NUMBERS_ORDERED;
	}
	
	public void searchByIDFor(int id) {
		System.out.println("Search for " + id);
		for(Media item : itemsOrdered) {
			if (item.getId() == id) {
				if (item instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvdItem = (DigitalVideoDisc)item;
					System.out.println(dvdItem.getDetail());
				} else if (item instanceof Book) {
					Book bookItem = (Book)item;
					System.out.println(bookItem.getDetail());
				} else {
					System.out.println("Downcasting error");
				}
				return;
			}
		}
		System.out.println("Cannot found");
	}
	
	public void searchByTitleFor(String key) {
		if (key == null) {
			System.out.println("The input string is null");
			return;
		}
		
		boolean isFound = false;
		for(Media item : itemsOrdered) {
			if (item.titleContains(key)) {
				if (item instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvdItem = (DigitalVideoDisc)item;
					System.out.println(dvdItem.getDetail());
				} else if (item instanceof Book) {
					Book bookItem = (Book)item;
					System.out.println(bookItem.getDetail());
				} else {
					System.out.println("Downcasting error");
				}
				isFound = true;
			}
		}
		if (!isFound) {
			System.out.println("\tCannot Found");
		}
	}
	
	// Sorting
	public void sortByCostAndPrint() {
		System.out.println("Sorted by cost");
		MediaUtils.sortByCost(itemsOrdered);
		printCart();
	}
	
	public void sortByTilteAndPrint() {
		System.out.println("Sorted by tilte");
		MediaUtils.sortByTitle(itemsOrdered);
		printCart();
	}
	
	public void sortByTitleAndCost() {
		System.out.println("Sorted by title and cost");
		MediaUtils.sortByTitleAndCost(itemsOrdered);
		printCart();
	}
	
	// Calculating
	public float totalCost() {
		float total = 0;
		for(Media item : itemsOrdered) {
			total += item.getCost();
		}
		return total;
	}
	
	
	
	//
	//
	// Getter
	public void getLuckyItem() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("The cart is empty");
			return;
		}
		if (hasLuckyNumber) {
			System.out.println("Your cart already have the lucky item");
			return;
		}
		int luckyNumber = (int) Math.round((itemsOrdered.size()-1) * Math.random());
		Media luckyItem = itemsOrdered.get(luckyNumber);
		System.out.println("Lucky item: ");
		if(luckyItem instanceof Book) {
			System.out.println(((Book) luckyItem).getDetail());
		} else {
			System.out.println(((DigitalVideoDisc) luckyItem).getDetail());
		}
		
		// Change the cost
		if (luckyItem instanceof Book) {
			Book newFreeItem = new Book();
			newFreeItem.copyContentOf((Book)luckyItem);
			newFreeItem.setCost(0);
			itemsOrdered.set(luckyNumber, newFreeItem);
		} else if (luckyItem instanceof DigitalVideoDisc) {
			DigitalVideoDisc newFreeItem = new DigitalVideoDisc(null);
			newFreeItem.copyContentOf((DigitalVideoDisc)luckyItem);
			newFreeItem.setCost(0);
			itemsOrdered.set(luckyNumber, newFreeItem);
		}
		hasLuckyNumber = true;
	}
}
