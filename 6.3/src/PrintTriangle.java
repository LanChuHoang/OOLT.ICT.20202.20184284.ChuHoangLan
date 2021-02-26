import java.util.Scanner;

public class PrintTriangle {
	public static void main(String arg[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		int n = input.nextInt();
		if (n <= 0) {
			System.out.println( "n must greater than 0");
		} else {
			int maxStar = (n - 1) * 2 + 1;
			for(int numStar = 1; numStar <= maxStar; numStar += 2) {
				// Print spaces
				for (int j = 1; j <= (maxStar - numStar) / 2; j++) {
					System.out.print(" ");
				}
				// Print stars
				for (int j = 1; j <= numStar; ++j) {
					System.out.print("*");
				}
				// Print spaces
				for (int j = 1; j <= (maxStar - numStar) / 2; j++) {
					System.out.print(" ");	
				}
				System.out.print("\n");
			}
		}
	}
}
