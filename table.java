import java.util.Scanner;

public class table {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int temp = 1;
		System.out.print("enter the table values=");
		int b = s.nextInt();
		for(int i=1; i<=10; i++) {
			System.out.println(i+" * "+b+" = "+i*b);
		}
	}
}
