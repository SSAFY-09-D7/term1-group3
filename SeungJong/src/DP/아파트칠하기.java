package study.DP;

import java.io.*;

public class 아파트칠하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}

}
