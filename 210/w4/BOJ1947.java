package w4;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ1947.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+2];
        long mod = 1_000_000_000;
        
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++)  {
            dp[i] = (i-1) * ((dp[i-1]%mod) + (dp[i-2]%mod));
        }

        System.out.println(dp[n] % mod);
    }
}
