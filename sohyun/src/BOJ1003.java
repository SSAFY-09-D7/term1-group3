import java.util.*;
import java.io.*;

public class BOJ1003 {
    public static void main(String[] args) throws Exception {
        // N번째 피보나치 수를구하는 함수
        // fibonacci(N) 을 호출했을 때 0과 1이 몇번 출력??
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.printf("%d %d\n", dp[N][0], dp[N][1]);
        }

    }

}
