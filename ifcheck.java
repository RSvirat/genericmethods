package zoho_logic;

import java.util.Scanner;

public class ifcheck {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please Enter the string value=");
		String str = s.next();
		
		convert(str);
	}
	public static void convert(String str) {
		char str1[] = str.toCharArray();
		
		int val = 0;
		for(int i=0;i<str.length();i++) {
			try {
				if(str1[i] >= '0' && str1[i] <= '9') {
					if(str1[i+1]>='0'&&str1[i+1]<='9') {
						String counts = String.valueOf(str1[i]);
						String counts1 = String.valueOf(str1[i+1]);
						val = Integer.parseInt(counts+counts1);
						printVal(str1[i-1],val);
						i++;
					} else {
						String counts = String.valueOf(str1[i]);
						val = Integer.parseInt(counts);
						printVal(str1[i-1],val);
					}
				}
			}catch(Exception e) {
				val = Integer.parseInt(String.valueOf(str1[i]));
				printVal(str1[i-1],val);
			}
		}
	}
	static void printVal(char c, int i) {
		while(i>0) {
			System.out.print(c);
			i--;
		}
	}
}	
