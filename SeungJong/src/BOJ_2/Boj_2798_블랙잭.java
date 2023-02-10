package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2798_블랙잭 {

	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		combination(new int[3], 0, 0);
		System.out.println(max);
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k==sel.length) {
			int temp = 0;
			for (int i = 0; i < sel.length; i++) {
				temp += sel[i];
			}
			if(temp <= M) max = Math.max(max, temp);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(sel, i+1, k+1);
		}
	}

}
