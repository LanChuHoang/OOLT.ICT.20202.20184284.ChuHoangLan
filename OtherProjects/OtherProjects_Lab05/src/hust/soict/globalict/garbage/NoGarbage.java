package hust.soict.globalict.garbage;

public class NoGarbage {
	public static void concatWithStringBuffer(String word, int numAdded) {
		StringBuffer s = new StringBuffer();
		for(int i = 0 ; i < numAdded; ++i) {
			s.append(word);
		}
	}
}
