package study.DP;

import java.io.*;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[][] memo = new int[n][2];
		// 0 -> 전 칸에서 올라옴
		// 1 -> 전전 칸에서 올라옴
		memo[0][0] = arr[0];
		memo[0][1] = arr[0];
		if(n>1) {
			memo[1][0] = memo[0][0] + arr[1];
			memo[1][1] = arr[1];
			for (int i = 2; i < n; i++) {
				memo[i][0] = memo[i-1][1] + arr[i];
				memo[i][1] = Math.max(memo[i-2][0] + arr[i], memo[i-2][1] + arr[i]);
			}
		}
		System.out.println(Math.max(memo[n-1][0], memo[n-1][1]));
	}

}
