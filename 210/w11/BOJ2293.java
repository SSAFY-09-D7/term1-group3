package w11;

import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./inputs/input_BOJ2293.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		int[] dp = new int[k+1];
		
		for (int i = 0; i < n; i++) 
			nums[i] = Integer.parseInt(br.readLine());
		

		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = nums[i]; j <= k; j++) { 
				dp[j] += dp[j - nums[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}