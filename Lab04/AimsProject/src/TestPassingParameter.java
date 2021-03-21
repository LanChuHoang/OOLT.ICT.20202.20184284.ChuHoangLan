
public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		correctSwap(jungleDVD, cinderellaDVD);
		//swap(jungleDVD, cinderellaDVD);
		//changeTitle(cinderellaDVD, jungleDVD.getTitle());
		//System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		//System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		
	}
	
	public static void swap(Object o1, Object o2) {
		Object temp = o1;
		o1 = o2;
		o2 = temp;
	}
	
	public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc dvdTemp = new DigitalVideoDisc(null);
		dvdTemp.copyContentOf(dvd1);
		dvd1.copyContentOf(dvd2);
		dvd2.copyContentOf(dvdTemp);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
