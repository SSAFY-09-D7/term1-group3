package w11;

import java.io.*;
import java.util.*;

public class BOJ11726 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ11726.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		if(n>=3) {
			for(int i = 3; i<=n; i++) {
				dp[i] = (dp[i-1] + dp[i-2])%10007;
			}
		}
		
		System.out.println(dp[n]);
	}

}
