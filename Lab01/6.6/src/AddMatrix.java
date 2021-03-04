
public class AddMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1  = { 
				{1,2,3},
				{4,5,6},
				{7,8,9} 
		};
		int[][] arr2  = { 
				{2,2,2},
				{2,2,2},
				{2,2,2} 
		};
		
		for(int i = 0; i < arr1.length; ++i)
		{
			for(int j = 0; j < arr1[0].length; ++j)
			{
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("+");
		for(int i = 0; i < arr2.length; ++i)
		{
			for(int j = 0; j < arr2[0].length; ++j)
			{
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=");
		for(int i = 0; i < arr2.length; ++i)
		{
			for(int j = 0; j < arr2[0].length; ++j)
			{
				System.out.print(arr1[i][j] + arr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
