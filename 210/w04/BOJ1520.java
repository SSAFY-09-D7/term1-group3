package w04;

import java.io.*;
import java.util.*;

class Solution {
    static int[][] ds = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1520.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[m][n];
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(dp, board, m, n, 0, 0);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int[][] dp, int board[][], int m, int n, int r, int c) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int dr = r + ds[i][0];
            int dc = c + ds[i][1];

            if (dr < 0 || dc < 0 || dr >= m || dc >= n)
                continue;

            if (board[dr][dc] < board[r][c]) {
                dp[r][c] += dfs(dp, board, m, n, dr, dc);
            }
        }

        return dp[r][c];
    }
}