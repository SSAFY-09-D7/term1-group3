package w14;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		int[][] dp = new int[N+1][M+1];
		int max = 0;
		
		for (int i = 0; i < N; i++)
			board[i] = br.readLine().toCharArray();

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if (board[i-1][j-1] == '0') continue;
				dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]);
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
				
				max = Math.max(max, ++dp[i][j]);
			}
		}
		
		System.out.println(max*max);
	}
}
