package study.DP;

import java.io.*;
import java.util.*;

public class BOJ_9465_스티커 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(n>1) {
				dp[0][1] = dp[1][0] + arr[0][1];
				dp[1][1] = dp[0][0] + arr[1][1];
				for (int i = 2; i < n; i++) {
					dp[0][i] = Math.max(dp[1][i-1]+arr[0][i], Math.max(dp[0][i-2],dp[1][i-2])+arr[0][i]);
					dp[1][i] = Math.max(dp[0][i-1]+arr[1][i], Math.max(dp[0][i-2],dp[1][i-2])+arr[1][i]);
				}
			}
			System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
		}
	}
}
