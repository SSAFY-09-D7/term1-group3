package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Swea_1234_D3 {
	static int N;
	static String str;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_swea1234.txt"));
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			str = sc.next();
			for (int i = 0; i < str.length() -1; i++) {
				String tmp = "";
				if(str.charAt(i) == str.charAt(i+1)) {
					if(str.charAt(0) == str.charAt(1)) {
						str = str.substring(2,str.length());
					} else {
						if(i != 0) {
							tmp = str;
							str = str.substring(0, i);
							if(i+2 < tmp.length()) str += tmp.substring(i+2, tmp.length());
						}
					}
						
					i = 0;
				}
			}
			System.out.println("#" + tc+" "+str);
		}
		sc.close();
	}
}
		
	


