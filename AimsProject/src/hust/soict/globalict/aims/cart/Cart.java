package hust.soict.globalict.aims.cart;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MediaUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private Media luckyItem;
	
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
		luckyItem = null;
	}
	
	// Display 
	public void printCart() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("\tThe Cart is empty");
		} else {
			int i = 0;
			for(Media item : itemsOrdered) {
				System.out.println("\t" + (i+1) + ". " + item.getDetail());
				i++;
			}
			if (luckyItem != null) {
				System.out.println("* Lucky item: " + luckyItem.getDetail());
			}
			System.out.println("\tTotal cost: " + totalCost() + " $");
		}
	}
	
	// Checking + Searching
	public boolean isFull() {
		return itemsOrdered.size() >= MAX_NUMBERS_ORDERED;
	}
	
	public Media searchByID(int id) {
		for(Media item : itemsOrdered) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	public void searchByTitleFor(String key) {
		if (key == null) {
			System.out.println("The input string is null");
			return;
		}
		
		boolean isFound = false;
		for(Media item : itemsOrdered) {
			if (item.titleContains(key)) {
				System.out.println(item.getDetail());
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
		if (luckyItem != null) {
			total -= luckyItem.getCost();
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
		if (luckyItem != null) {
			System.out.println("Your cart already have the lucky item");
			return;
		}
		
		// Generate the lucky item
		int luckyNumber = (int) Math.round((itemsOrdered.size()-1) * Math.random());
		luckyItem = itemsOrdered.get(luckyNumber);
		
		// Print the result
		System.out.println("Your lucky item: ");
		System.out.println(luckyItem.getDetail());
		System.out.println("Total cost: " + totalCost() + " $");
		
	}
}
