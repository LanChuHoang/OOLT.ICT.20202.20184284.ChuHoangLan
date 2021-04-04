package hust.soict.globalict.aims.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaUtils {
	public static void sortByCost(ArrayList<Media> items) {
		Collections.sort(items, Comparator.comparing(Media::getCost));
	}
	
	public static void sortByTitle(ArrayList<Media> items) {
		Collections.sort(items, Comparator.comparing(Media::getTitle));
	}
	
	public static void sortByTitleAndCost(ArrayList<Media> items) {
		Collections.sort(items, Comparator.comparing(Media::getTitle)
				.thenComparing(Media::getCost));
	}
}


