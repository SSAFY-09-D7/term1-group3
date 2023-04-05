package w12;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (i > 0) dp[i] = Math.max(dp[i], dp[i-1]);
            if (i+t <= N) dp[i+t] = Math.max(dp[i+t], dp[i] + p);
        }

        dp[N] = Math.max(dp[N], dp[N-1]);
        System.out.println(dp[N]);
    }
}
