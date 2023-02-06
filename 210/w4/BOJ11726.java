package w4;

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ11726.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
        	dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}