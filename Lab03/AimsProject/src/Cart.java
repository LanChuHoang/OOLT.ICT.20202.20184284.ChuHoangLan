import java.util.Iterator;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered;
	
	public void printCart() {
		if (qtyOrdered <= 0) {
			System.out.println("The cart is empty");
		} else {
			for(int i = 0; i < qtyOrdered; ++i) {
				System.out.print(itemsOrdered[i].getTitle() + " - ");
				System.out.print(itemsOrdered[i].getCategory() + " - ");
				System.out.print(itemsOrdered[i].getDirector() + " - "); 
				System.out.print(itemsOrdered[i].getLength() + " - ");
				System.out.print(itemsOrdered[i].getCost());
				System.out.println();
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added successfully.");
		} else {
			System.out.println("The cart is full. Please remove some items to add new one");
		}
	}
	
	public DigitalVideoDisc searchDVD(DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; ++i) {
			if (itemsOrdered[i] == disc) {
				return itemsOrdered[i];
			}
		}
		return null;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	}
	
	public float totalCost() {
		float total = 0;
		for(int i=0; i<qtyOrdered; ++i) {
			float disCost = itemsOrdered[i].getCost();
			total += disCost;
		}
		return total;
	}
}
