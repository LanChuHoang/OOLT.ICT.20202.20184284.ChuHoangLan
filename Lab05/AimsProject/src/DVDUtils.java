import java.util.Arrays;

public class DVDUtils {
	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		float cost1 = dvd1.getCost();
		float cost2 = dvd2.getCost();
		if (cost1 > cost2) {
			return 1;
		} else if (cost1 == cost2) {
			return 0;
		}
		return -1;
	}
	
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int result = dvd1.getTitle().compareTo(dvd2.getTitle());
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		}
		return 0;
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvds) {
		for(int i = 0; i < dvds.length; ++i) {
			if (dvds[i] == null) {
				break;
			}
			for(int j = i + 1; j < dvds.length; ++j) {
				if (dvds[j] == null) {
					break;
				}
				if (dvds[j].getCost() < dvds[i].getCost()) {
					DigitalVideoDisc temp = dvds[i];
					dvds[i] = dvds[j];
					dvds[j] = temp;
				}
			}
		}
		return dvds;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvds) {
		for(int i = 0; i < dvds.length; ++i) {
			if (dvds[i] == null) {
				break;
			}
			for(int j = i + 1; j < dvds.length; ++j) {
				if (dvds[j] == null) {
					break;
				}
				int compareResult = compareByTitle(dvds[i], dvds[j]);
				if (compareResult == 1) {
					DigitalVideoDisc temp = dvds[i];
					dvds[i] = dvds[j];
					dvds[j] = temp;
				}
			}
		}
		return dvds;
	}
}
