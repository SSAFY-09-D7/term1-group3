package BOJ_4;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		arr[0] = 0;
		arr[1] = 0;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1]+1;
			if(i%3 == 0) arr[i] = Math.min(arr[i], arr[i/3]+1);
			if(i%2 == 0) arr[i] = Math.min(arr[i], arr[i/2]+1);
		}
		System.out.println(arr[N]);
		System.out.println(Arrays.toString(arr));
	}
}
