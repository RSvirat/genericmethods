package workout_programs;

import java.util.Scanner;

public class Suduko_problem {
	static int N = 0;
	public static void main(String args[]) {
		int sudukoBroad[][] = new int[9][9]; 
		Scanner s = new Scanner(System.in);
		System.out.println("pleas Enter the suduko puzzle = ");
		for(int row=0; row<9; row++) {
			for(int col=0; col<9; col++) {
				sudukoBroad[row][col] = s.nextInt();
			}
		}
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				System.out.print(sudukoBroad[row][col]+" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		N = sudukoBroad.length;
		result(sudukoBroad);
	}
	public static void result(int sudukoBroad[][]) {
		if(solveSuduko(sudukoBroad)) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(sudukoBroad[i][j]+" ");
					System.out.print("");
					if((j+1)%(int) Math.sqrt(N) == 0) {
						System.out.print(" ");
					}
				}
				System.out.println("");
				if((i+1)%(int) Math.sqrt(N) == 0) {
					System.out.println(" ");
				}
			}
		}
	}
	public static boolean solveSuduko(int sudukoBroad[][]) {
		int row = 0;
		int col = 0;
		boolean breaking = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(sudukoBroad[i][j] == 0) {
					row = i;
					col = j; 
					breaking = false;
					break;
				}
			}
			if(!breaking) {
				break;
			}
		}
		if(breaking) {
			return true;
		}
		for(int n=1; n<=N; n++) {
			if(sudukoSafe(sudukoBroad, row, col, n)) {
				sudukoBroad[row][col] = n;
				if(solveSuduko(sudukoBroad)) {
					return true;
				}
				else {
					sudukoBroad[row][col] = 0;
				}
			}
		}
		return false;
	}
	public static boolean sudukoSafe(int sudukoBroad[][], int row, int col, int num) {
		for(int i = 0; i < N; i++) {
			if(sudukoBroad[row][i] == num){
				return false;
			}
		}
		for(int j=0; j<N;j++) {
			if(sudukoBroad[j][col] == num) {
				return false;
			}
		}
		
		int box = (int) Math.sqrt(N);
		int boxRow = row - row % box;
		int boxCol = col - col % box;
		for(int i = boxRow; i<boxRow+box; i++) {
			for(int j = boxCol; j<boxCol+box; j++) {
				if(sudukoBroad[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
