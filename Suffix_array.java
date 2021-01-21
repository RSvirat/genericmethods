package hacker_rank;

import java.util.Scanner;

public class Suffix_array {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String X = null;
		String Y = null;
		System.out.println("Enter the String value = ");
		String suffix = s.next();
		String arr[] = suffix.split(",");
		for(int i = 0; i<arr.length; i++) {
			if(i == 1) {
				Y = arr[i];
			} else {
				X = arr[i];
			}
		}
		int m = X.length();
		int n = Y.length();
		suffix(X,Y,m,n);
	}
	public static void suffix(String X,String Y,int m,int n) {
		 System.out.println(X+" "+Y+" "+m+" "+n);
		 int[][] LCSuffix = new int[m+1][n+1];
		 int len = 0;
		 int row = 0, col = 0;
		 for(int i = 0; i <= m; i++) {
			 for(int j = 0; j <= n; j++) {
				 if(i == 0 || j == 0) {
					 LCSuffix[i][j] = 0;
					 
				 } else if(X.charAt(i-1) == Y.charAt(j-1)) {
					
					 LCSuffix[i][j] = LCSuffix[i-1][j-1] + 1;
					 if(len < LCSuffix[i][j]) {
						 len = LCSuffix[i][j];
						 row = i;
						 col = j;
					 }
				 } else {
					 LCSuffix[i][j] = 0;
				 }
			 }
		 } 
		 
		 if(len == 0) {
			 System.out.println("No common Substring");
		 }
		 String result = "";
		 
		 while(LCSuffix[row][col] != 0) {
			 result = (String) (X.charAt(row-1) + result);
			 row--;
			 col--;
		 }
		 System.out.println(result);
	}
}
