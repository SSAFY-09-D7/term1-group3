package study.DP;

import java.io.*;
import java.util.*;

public class BOJ_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] memo = new int[n];
		/*
		 * max값을 계속해서 업데이트?
		 * 그 max값에서 이어지는 메모이제이션
		 */
		int max = 1;
		memo[0] = 1;
		for (int i = 1; i < n; i++) {
			memo[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) {
					memo[i] = Math.max(memo[i], memo[j]+1);
				}
			}
			max = Math.max(memo[i], max);
		}
		System.out.println(max);
	}
}
