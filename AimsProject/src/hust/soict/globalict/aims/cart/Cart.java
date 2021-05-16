package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private Media luckyItem;
	
	// Getter & Setter
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
		System.out.println(luckyItem.toString());
		System.out.println("Total cost: " + totalCost() + " $");
		
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	// Update
	public void addMedia(Media...newMediaList) {
		for (Media newMedia : newMediaList) {
			if (this.isFull()) {
				System.out.println("The cart is full. Cannot add more media");
				return;
			} else {
				if (newMedia == null) {
					System.out.println("The new media is null");
				} else if (!itemsOrdered.contains(newMedia)) {
					itemsOrdered.add(newMedia);
					System.out.println("Added " + newMedia.getTitle() + " to the Cart");
				} else {
					System.out.println("The media " + newMedia.getTitle() + " is already in the Cart");
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
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
	}
	
	public void emptyCart() {
		itemsOrdered = FXCollections.observableArrayList();
		luckyItem = null;
	}
	
	// Display 
	public void printCart() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("\tThe Cart is empty");
		} else {
			int i = 0;
			for(Media item : itemsOrdered) {
				System.out.println("\t" + (i+1) + ". " + item.toString());
				i++;
			}
			if (luckyItem != null) {
				System.out.println("* Lucky item: " + luckyItem.toString());
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
				System.out.println(item.toString());
				isFound = true;
			}
		}
		if (!isFound) {
			System.out.println("\tCannot Found");
		}
	}
	
	// Sorting
	public void sortByTitleAndCategory() {
		Collections.sort(itemsOrdered);
	}
	
	public void sortByTitleAndCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCostAndTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
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


	


	
	
}
