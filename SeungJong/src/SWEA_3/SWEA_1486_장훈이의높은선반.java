package SWEA.SWEA3;

import java.io.*;
import java.util.*;

public class SWEA_1486_장훈이의높은선반 {
	static int N, S, Ans;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea1486.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			Ans = Integer.MAX_VALUE;
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0);
			System.out.println("#"+tc+" "+(Ans - S));
		}
	}
	private static void solve(int i, int sum) {
		if(sum >= S) {
			Ans = Math.min(Ans, sum);
			return;
		}
		if(i+1 <= N) {
			solve(i+1, sum+arr[i]);
			solve(i+1, sum);
		}
	}
}
