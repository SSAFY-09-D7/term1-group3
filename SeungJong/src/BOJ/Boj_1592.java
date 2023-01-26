package BOJ;

import java.util.Scanner;

public class Boj_1592 {

	static int N, M, L, i, Count = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		arr = new int[N];
		i = 0;
		while(true) {
			if(arr[i] % 2 == 1) {
				i += L;
				if(i >= N) i -= N;
			} else {
				i -= L;
				if(i<0) i += N;
			}
			Count += 1;
			arr[i] += 1;
			if(arr[i]>=M) break;
		}
		System.out.println(Count-1);
		sc.close();
	}

}
