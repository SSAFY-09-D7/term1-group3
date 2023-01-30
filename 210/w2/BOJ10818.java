package w2;

import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./inputs/input_BOJ10818.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int currNum = sc.nextInt();
			
			min = Math.min(min, currNum);
			max = Math.max(max, currNum);
		}
		
		System.out.println(min + " " + max);
		
		sc.close();
	}
}
