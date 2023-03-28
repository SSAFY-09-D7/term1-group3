package study.DP;

import java.io.*;

public class BOJ_9095_123더하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[11];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < arr.length; i++) {
			arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
		}
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[n]);
		}
	}
}
