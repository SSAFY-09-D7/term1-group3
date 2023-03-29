package w11;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n][m];
        
        for (int[] p : puddles) {
            dp[p[1]-1][p[0]-1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            if (dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                if (dp[i-1][j] == -1) dp[i][j] = (dp[i][j]+1) % 1000000007;
                if (dp[i][j-1] == -1) dp[i][j] = (dp[i][j]+1) % 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}
