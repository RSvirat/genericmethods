package hacker_rank;

import java.util.Scanner;

public class SumOfHourGlass {
	public static void main(String args[]) {
		int max_sum = 0;
		int a[][] = new int[6][6];
		Scanner s = new Scanner(System.in);
		for(int i=0; i<6;i++) {
			for(int j=0;j<6;j++) {
				a[i][j] = s.nextInt();
			}
		}
		for(int i=0;i<6-2; i++) {
			for(int j=0;j<6-2;j++) {
				int sum = (a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2]);
				max_sum = Math.max(max_sum, sum);
			}
		}
		System.out.println(max_sum);
	}
}
