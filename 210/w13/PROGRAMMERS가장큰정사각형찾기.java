package w13;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int H = board.length;
        int W = board[0].length;
        int[][] dp = new int[H+1][W+1];
        
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (board[i-1][j-1] == 0) continue; 
                dp[i][j] = dp[i-1][j-1];
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);

                answer = Math.max(++dp[i][j], answer);
            }
        }

        return answer * answer;
    }
}
