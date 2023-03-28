package study.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] memo = new int[n][3];
		memo[0][0] = arr[0][0];
		memo[0][1] = arr[0][1];
		memo[0][2] = arr[0][2];
		for (int i = 1; i < n; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + arr[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + arr[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(memo[n-1][0], memo[n-1][1]),memo[n-1][2]));
	}
}
