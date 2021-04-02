package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media() {
	}
	
	// Getter
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	// Setter
	public void setTitle(String title) {
		this.title = title;
	}

}
