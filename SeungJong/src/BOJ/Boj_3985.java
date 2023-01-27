package BOJ;

import java.util.Scanner;

public class Boj_3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L];
		int[] P = new int[N];
		int[] K = new int[N];
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt()-1;
			K[i] = sc.nextInt()-1;
		}
		int predictMax = CalPredictMax(P, K);
		System.out.println(predictMax);
		int realMax = CalRealMax(cake, P, K, N);
		System.out.println(realMax);
		sc.close();
	}

	private static int CalRealMax(int[] cake, int[] p, int[] k, int n) {
		for (int i = 0; i < p.length; i++) {
			for (int j = p[i]; j <= k[i]; j++) {
				if(cake[j] == 0) cake[j] = i+1;
			}
		}
		return CalMaxCount(cake, n);
	}

	private static int CalMaxCount(int[] cake, int n) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 0; j < cake.length; j++) {
				if(cake[j] == i) count += 1;
			}
			if(max < count) {
				max = count;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private static int CalPredictMax(int[] p, int[] k) {
		int maxVal = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < k.length; i++) {
			int diff = k[i] - p[i];
			if(diff > maxVal) {
				maxVal = diff;
				maxIndex = i;
			}
		}
		return maxIndex+1;
	}


}
