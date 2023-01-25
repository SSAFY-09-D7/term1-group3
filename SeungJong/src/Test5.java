package Test_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test5_이승종 {
	static String[] arr = {"000000","001111","010011",
			"011100","100110","101001","110101","111010"};
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = "0";
		str += sc.next();
		String temp= "";
		String ans = "";
		int index = 0;
		int a = 0;
		boolean isBreak = false;
		boolean isFind = false;
		int[] count = new int[8];
		for (int i = 1; i <= N*6; i++) {
			temp += str.charAt(i);		
			if(!isBreak) {
				if(i%6 == 0) {
					for (int j = 0; j < count.length; j++) {
						count[j] = 0;
					}
					a += 1;
					int min_count = Integer.MAX_VALUE;
					isFind = false;
					isBreak = false;
					for (int j = 0; j < arr.length; j++) {
						if(temp.equals(arr[j])) {
							ans += j;
							isFind = true;
							break;
						}
					}
					if(!isFind) {
						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 6; k++) {
								if(temp.charAt(k) != arr[j].charAt(k)) {
									count[j] += 1;
								}
							}
						}
						for (int j = 0; j < count.length; j++) {
							if(min_count > count[j]) {
								min_count = count[j];
								index = j;
							}
						}
						if(count[index] <= 1) {
							ans += index;
						}
						else {
							isBreak = true;
						}
						
					}
					temp = "";
				}	
			}
		}
		if(isBreak) {
			System.out.println(a);
		}
		else {
			for (int i = 0; i < ans.length(); i++) {
				System.out.printf("%c",(int)ans.charAt(i) + 17);
			}
		}
		sc.close();
	}
}