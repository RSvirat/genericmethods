package workout_programs;

public class Rat_Maze_Problem {
	static int N=4;
	
	public static void main(String args[]) {
		int maze[][] = {
			{1,1,0,0},
			{1,1,0,0},
			{0,1,0,0},
			{1,1,1,1}
		};
		N = maze.length;
		result(maze);
	}
	public static void result(int maze[][]) {
		int sol[][] = new int[N][N];
		if(ratsolve(maze,0,0,sol)) {
			System.out.println("Dosn't valid");
		} 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(" " +sol[i][j]+ " ");
			}
			System.out.println(" ");
		}
	}
	public static boolean ratsolve(int maze[][],int x, int y, int sol[][]) {
		
		if(x == N-1 && y == N-1 && maze[x][y] == 1) {
			sol[x][y] = 1;
		}
		if(ratsafe(maze,x,y) == true) {
			
			sol[x][y] = 1;
			
			if(ratsolve(maze,x+1,y,sol)) {
				return true;
			}
			if(ratsolve(maze,x,y+1,sol)) {
				return true;
			}
		}	
		return false;
	}
	public static boolean ratsafe(int maze[][],int x, int y) {
		return(x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	}
}
