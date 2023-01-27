package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_3460 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			FindBit(N);			
		}
		sc.close();
	}
	private static void FindBit(int n) {
		int sum = 0;
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 0;; i++) {
			if((n & (1<<i)) > 0) {
				arrList.add(i);
				sum += 1<<i;
			}
			if(sum == n) break;
		}
		for (int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i)+" ");			
		}
		System.out.println("");
	}

}
