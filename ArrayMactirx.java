package array;

import java.util.Scanner;

public class ArrayMactirx {
	public static void main(String arg[]) {
	Scanner s = new Scanner(System.in);
	System.out.print("Enter the array index=");
	int a = s.nextInt();
	int i,j;
	int b = s.nextInt();
	int arr[][] = new int[a][b];
	int arr1[][] = new int[a][b];
	int add[][] = new int[a][b];
	int max=add[0][0];
	int add1 = 0;
	int addmax = 0;
	System.out.println("Enter the first matrix");
	for(i=0; i < a; i++) {
		for(j=0; j < b; j++) { 
			arr[i][j] = s.nextInt();
			System.out.print(arr[i][j]+" ");
		}
	System.out.println(" ");
	}
			
	System.out.println("Enter the second matrix");
	for(i=0; i < a; i++) {
		for(j=0; j < b; j++) { 
			arr1[i][j] = s.nextInt(); 
			System.out.print(arr1[i][j]+" ");
		}
	System.out.println(" ");
	}
	for(i=0; i < a; i++) {
		for(j=0; j < b; j++) {
			add[i][j] = arr[i][j]+arr1[i][j]; 
		}
	}
	System.out.println("addition of matrix");
	for(i=0; i < a; i++) {
		for(j=0; j < b; j++) {
			System.out.print(add[i][j]+" ");
			if(add[i][j]>max) {
				max = add[i][j];
			}
		}
		addmax = addmax+max;
		System.out.println(" ");
		System.out.println("max value in"+max+"row="+max);
		System.out.println("max value"+add1+"+"+max+"add="+addmax);
		max=0;
		add1 = addmax;
	}
	}
}
