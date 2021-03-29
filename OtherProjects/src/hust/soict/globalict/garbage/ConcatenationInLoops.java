package hust.soict.globalict.garbage;

import java.io.IOException;

public class ConcatenationInLoops {

	public static void main(String[] args) throws IOException {
		long startTime, endTime, totalTime;
		String wordAdded = "Hoang Lan";
		int numAdded = 100000;
		
		// Concat with String
		startTime = System.currentTimeMillis();
		GarbageCreator.concatWithString(wordAdded, numAdded);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time taken by Concating with String: " + totalTime + " ms");
		
		// Concat with StringBuffer
		startTime = System.currentTimeMillis();
		NoGarbage.concatWithStringBuffer(wordAdded, numAdded);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Time taken by Concating with StringBuffer: " + totalTime + " ms");
		
	}

}
