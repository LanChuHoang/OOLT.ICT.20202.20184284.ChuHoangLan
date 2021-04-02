
public class SortArray {
	
	static void sort(int[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			for (int j = i+1; j < arr.length; ++j) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 2, 4, 6, 8, 1 ,3 ,5, 7, 9};
		int sum = 0;
		double average = 0.0;
		
		System.out.println("The array: ");
		for(int i = 0; i < arr.length; ++i)
		{
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		average = (double)sum / (double)arr.length;
		
		System.out.println("\nThe sorted array: ");
		sort(arr);
		for(int i = 0; i < arr.length; ++i)
		{
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		
		
		System.out.print("\nSum: " + sum + " Average: " + average);
	}

}
