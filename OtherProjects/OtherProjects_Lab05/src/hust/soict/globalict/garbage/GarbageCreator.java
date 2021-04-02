package hust.soict.globalict.garbage;

public class GarbageCreator {
	public static void concatWithString(String word, int numAdded) {
		String s = "";
		for(int i = 0 ; i < numAdded; ++i) {
			s += word;
		}
	}
}
