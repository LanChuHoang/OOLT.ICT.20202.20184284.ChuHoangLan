package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.AlreadyHaveLuckyItemException;
import hust.soict.globalict.aims.exception.NotEnoughItemException;
import hust.soict.globalict.aims.exception.NotEnoughPriceException;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public static final float MIN_PRICE_TO_HAVE_LUCKY_ITEM = 10;
	public static final int MIN_NUM_ITEM_TO_HAVE_LUCKY_ITEM = 3;
	public static final float MAX_LUCKY_ITEM_PRICE = 100;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private Media luckyItem;
	
	// Getter & Setter
	public Media getLuckyItem() throws AlreadyHaveLuckyItemException, NotEnoughPriceException, NotEnoughItemException {
		if (luckyItem != null) {
			throw new AlreadyHaveLuckyItemException("The cart is already have a lucky item");
		}
		if (totalCost() < MIN_PRICE_TO_HAVE_LUCKY_ITEM) {
			throw new NotEnoughPriceException("Not enough price. The minimum price is " + MIN_PRICE_TO_HAVE_LUCKY_ITEM + " $ !");
		}
		if (itemsOrdered.size() < MIN_NUM_ITEM_TO_HAVE_LUCKY_ITEM) {
			throw new NotEnoughItemException("Not enough item. The minimum number of items is " + MIN_NUM_ITEM_TO_HAVE_LUCKY_ITEM + " !");
		}
		
		// Generate the lucky item
		float avgPrice = totalCost()/itemsOrdered.size();
		do {
			int luckyNumber = (int) Math.round((itemsOrdered.size()-1) * Math.random());
			luckyItem = itemsOrdered.get(luckyNumber);
		} while(luckyItem.getCost() > avgPrice && luckyItem.getCost() > MAX_LUCKY_ITEM_PRICE);
		return luckyItem;
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	// Update
	public void addMedia(Media...newMediaList) throws LimitExceededException {
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
	
	public void removeMedia(int id) {
		for (Media item : itemsOrdered) {
			if (item.getId() == id) {
				itemsOrdered.remove(item);
				System.out.println("Removed " + id + " from the Cart");
				return;
			}
		}
		throw new IllegalArgumentException("The media " + id + " is not in the Cart");
		
	}
	
	public void removeMedia(Media media) {
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
	
	public Media searchByTitleFor(String key) {
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
