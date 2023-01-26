package w2;

import java.util.*;
import java.util.regex.Pattern;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(new File("./inputs/input_BOJ1592.txt"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		int[] nums = new int[n];
		int currentIdx = 0;
		int cnt = 0;
		while (true) {
			currentIdx = getNextIdx(currentIdx, true, l, n);
			
			if (++nums[currentIdx] == m) break;
			cnt++;
		}
		
		System.out.println(cnt + " ");
		sc.close();
	}
	
	private static int getNextIdx(int currentIdx, boolean isOdd, int dis, int n) {
		if (isOdd) return (currentIdx + dis) % n;
		return ((currentIdx + n) - dis) % n;
	}
	
}