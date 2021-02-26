import java.util.Scanner;
import java.lang.Math;
public class EquationSolver {
	
	static void linearOne() {
		// Linear one variable
		// Input
		Scanner input = new Scanner(System.in);
		System.out.println("Linear equation with 1 variable");
		System.out.println("Enter a: ");
		int a = input.nextInt();
		System.out.println("Enter b: ");
		int b = input.nextInt();
		
		// Solve
		if (a == 0) {
			System.out.println("a cannot be equal to 0");
		} else {
			System.out.println("The solution of " + a + " * x + " + b + " = 0 is " + (-b/a));
		}
	}
	
	static void linearTwo() {
		// Linear Two
		// Input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Linear system with 2 variables");
		System.out.println("Enter a1: ");
		int a1 = input.nextInt();
		System.out.println("Enter b1: ");
		int b1 = input.nextInt();
		System.out.println("Enter c1: ");
		int c1 = input.nextInt();
		System.out.println("Enter a2: ");
		int a2 = input.nextInt();
		System.out.println("Enter b2: ");
		int b2 = input.nextInt();
		System.out.println("Enter c2: ");
		int c2 = input.nextInt();
		
		// Solve
		double a1DivA2 = (double)a1/(double)a2;
		double b1DivB2 = (double)b1/(double)b2;
		double c1DivC2 = (double)c1/(double)c2;
		
		if (a1DivA2 != b1DivB2) {
			double xSolution = (double)(c1*b2 - c2*b1) / (double)(a1*b2 - a2*b1);
			double ySolution = (double)(c1 - a1*xSolution) / (double)(b1);
			System.out.println("The system has an unique solution: ");
			System.out.println("x = " + xSolution);
			System.out.println("y = " + ySolution);
		} else {
			if (a1DivA2 == c1DivC2) {
				System.out.println("The system has infinitely many solutions.");
			} else {
				System.out.println("The system has no solution: ");
			}
		}
	}
	
	static void twoDegree() {
		// Input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a: ");
		double a = input.nextDouble();
		System.out.println("Enter b: ");
		double b = input.nextDouble();
		System.out.println("Enter c: ");
		double c  = input.nextDouble();
		
		// Solve
		if (a == 0) {
			System.out.println("a cannot be equal to 0");
		} else {
			double delta = b * b - a * c * 4;
			if (delta == 0) {
				System.out.println("The equation has an unique solution");
				double x = -b/2*a;
				System.out.println("x = " + x);
			} else if (delta > 0) {
				System.out.println("The equation has 2 solutions");
				double x1 = (-b + Math.sqrt(delta)) / (2*a);
				double x2 = (-b - Math.sqrt(delta)) / (2*a);
				System.out.println(x1 + " and " + x2);
			} else {
				System.out.println("The equation has no solution");
			}
		}
	} 
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. a*x + b = c");
		System.out.println("2. a1*x + b1*y = c1 & a2*x + b2*y = c2");
		System.out.println("1. a*x^2 + b*x + c = 0");
		System.out.println("Your choice: ");
		
		int chosen = input.nextInt();
		switch (chosen) {
		case 1: 
			linearOne();
			break;
		case 2: 
			linearTwo();
			break;
		case 3:
			twoDegree();
			break;
			default: 
				System.out.println("Invalid");
		}
		
	}
}
