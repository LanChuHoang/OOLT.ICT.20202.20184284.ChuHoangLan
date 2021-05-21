package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private Media luckyItem;
	
	// Getter & Setter
	public Media getLuckyItem() {
		if (itemsOrdered.isEmpty()) {
			return null;
		}
		
		// Generate the lucky item
		if (luckyItem == null) {
			int luckyNumber = (int) Math.round((itemsOrdered.size()-1) * Math.random());
			luckyItem = itemsOrdered.get(luckyNumber);
		}
		return luckyItem;
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	// Update
	public void addMedia(Media...newMediaList) throws LimitExceededException, NullPointerException, IllegalArgumentException {
		for (Media newMedia : newMediaList) {
			if (this.isFull()) {
				throw new LimitExceededException("The cart is full. Cannot add more media");
			} else if (newMedia == null) {
				throw new NullPointerException("The input media is null");
			} else if (itemsOrdered.contains(newMedia)) {
				throw new IllegalArgumentException("The media " + newMedia.getTitle() + " is already in the Cart");
			} else {
				itemsOrdered.add(newMedia);
				System.out.println("Added " + newMedia.getTitle() + " to the Cart");
			}
		}
	}
	
	public void removeMedia(int id) throws IllegalArgumentException{
		for (Media item : itemsOrdered) {
			if (item.getId() == id) {
				itemsOrdered.remove(item);
				System.out.println("Removed " + id + " from the Cart");
				return;
			}
		}
		throw new IllegalArgumentException("The media " + id + " is not in the Cart");
		
	}
	
	public void removeMedia(Media media) throws NullPointerException, IllegalArgumentException {
		if (media == null) {
			throw new NullPointerException("The input media is null");
		} else if (!itemsOrdered.contains(media)){
			throw new IllegalArgumentException("The media " + media.getTitle() + " is not in the cart");
		} else {
			itemsOrdered.remove(media);
			System.out.println("Removed " + media.getTitle() + " from the Cart");
		}
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
	
	public Media searchByTitleFor(String key) throws NullPointerException {
		if (key == null) {
			throw new NullPointerException("The input string is null");
		}
		
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(key)) {
				return media;
			}
		}
		return null;
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
			if (luckyItem == null || !luckyItem.equals(item)) {
				total += item.getCost();
			}
		}
		return total;
	}


	


	
	
}
