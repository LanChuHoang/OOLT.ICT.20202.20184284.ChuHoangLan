import java.util.*;  

public class CalculatingExercise {
	public static void main(String[] args) {
		
		// Input
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a: ");
		double a = input.nextDouble();
		System.out.println("Enter b: ");
		double b = input.nextDouble();		
		
		// Calculate
		// Sum 
		System.out.println(a + " + " + b + " = " + (a + b));
		
		// Difference
		System.out.println(a + " - " + b + " = " + (a - b));
		
		// Product
		System.out.println(a + " * " + b + " = " + (a * b));
		
		// Quotient
		if (b == 0) {
			System.out.println("The divisor cannot be equal to 0");
		} else {
			System.out.println(a + " / " + b + " = " + (a / b));
		}

	}
}
