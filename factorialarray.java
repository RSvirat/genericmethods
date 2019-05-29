import java.util.Scanner;

public class factorialarray {
	public static void main(String arg[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("enter the value=");
		int len = s.nextInt();
		int arr[] = new int[len];
		int temp = 0;
		long fact = 1;
		System.out.print("Enter the array value only "+len+"=");
		for(int i=0; i<=arr.length-1;i++) {
			arr[i] = s.nextInt();
			temp = arr[i];
			for(int j=1; j<=temp; j++) {
				fact *=j;
			}
			System.out.println("factorial of "+arr[i]+" = "+fact+",");
			fact = 1;
		}
	}
}
