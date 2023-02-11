package w4;

import java.util.*;
import java.io.*;

class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./inputs/input_BOJ7696.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] rNums = getNums(); 
		int target = -1;
		
		while (true) {
			target = Integer.parseInt(br.readLine());
			if (target == 0) break;
			bw.append(rNums[target] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	private static int[] getNums() {
		int rNums[] = new int[1000001];
		int num = 1;
		int rIdx = 1;
		
		while(rIdx <= 1000000) {			
			if (isRepeat(num)) {
				rNums[rIdx++] = num;
			}
			num++;
		}
		
		return rNums;
	}
	
	private static boolean isRepeat(int n) {
		boolean[] used = new boolean[10];
		
		int currNum = n;
		while (currNum > 0) {
			if (used[currNum % 10]) return false;
			used[currNum % 10] = true;
			currNum /= 10;
			
			if (currNum < 1) break;
		}
		
		return true;
	}
}
