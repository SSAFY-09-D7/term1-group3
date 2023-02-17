package SWEA_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_9229_한빈이와SpotMart {

	static int N, M, Ans;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(new int[2], 0, 0);
			System.out.print("#"+tc+" ");
			System.out.println(Ans==0?-1:Ans);
		}
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k == sel.length) {
			int sum = sel[0] + sel[1];
			if(sum<=M) {
				Ans = Math.max(Ans, sum);
			}
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(sel, i+1, k+1);
		}
	}

}
