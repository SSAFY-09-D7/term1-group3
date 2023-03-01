package BOJ_4;

import java.io.*;
import java.util.*;

public class Boj_2293_동전1 {

	static int N, K, Ans;
	static int[] arr;
	static int[] count;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		count = new int[K+1];
		for (int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		count[0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j - arr[i] >= 0 ) count[j] += count[j - arr[i]];
			}
		}
		System.out.println(count[K]);
	}
}
