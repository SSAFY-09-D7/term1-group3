package BOJ_4;

import java.io.*;
import java.util.*;

public class Boj_2294_동전2 {

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
		for (int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		count = new int[K+1];
		Arrays.fill(count, 100001);
		count[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = arr[i]; j <= K; j++) {
				count[j] = Math.min(count[j], count[j - arr[i]]+1);
			}
		}
		System.out.println(count[K] == 100001? -1 : count[K]);
	}
}
