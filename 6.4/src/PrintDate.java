import java.util.Scanner;

public class PrintDate {
	public static int month;
	public static int year;
	
	static void inputMonth() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter month:");
		String input = sc.nextLine();
		
		switch (input) {
		case "January", "Jan.", "Jan", "1": 
			month = 1;
			break;
		case "Febuary", "Feb.", "Feb", "2": 
			month = 2;
			break;
		case "March", "Mar.", "Mar", "3": 
			month = 3;
			break;
		case "April", "Apr.", "Apr", "4": 
			month = 4;
			break;
		case "May", "May.", "5": 
			month = 5;
			break;
		case "June", "Jun", "6": 
			month = 6;
			break;
		case "July", "Jul", "7": 
			month = 7;
			break;
		case "August", "Aug.", "Aug", "8": 
			month = 8;
			break;
		case "September", "Sept.", "Sep", "9": 
			month = 9;
			break;
		case "October", "Oct.", "Oct", "10": 
			month = 10;
			break;
		case "November", "Nov.", "Nov", "11": 
			month = 11;
			break;
		case "December", "Dec.", "Dec", "12": 
			month = 12;
			break;
		default: 
			System.out.println("Invalid");
			month = 0;
			break;
		}
	}
	
	static void inputYear() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter year:");
		String yearInput = input.nextLine();
		try {
			int yearNumber = Integer.parseInt(yearInput);
			if (year < 0) {
				System.out.println("Invalid");
				return;
			}
			year = yearNumber;
		} catch (Exception e) {
			System.out.println("Invalid");
			year = -1;
		}
		
	}
	
	static void printDate() {
		switch (month) {
		case 1 , 3, 5, 7, 8, 10, 12:
			System.out.println("31 days");
			break;
		case 4, 6, 9, 11:
			System.out.println("30 days");
			break;
		case 2:
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				System.out.println("29 days");
			} else {
				System.out.println("28 days");
			}
			break;
			default: 
				System.out.println("Invalid");
				break;
		}
	}
	
	public static void main(String[] args) {
		inputMonth();
		if (month != 0) {
			inputYear();
			if (year != -1)
			{
				printDate();
			}
		}
	}
}
