package SWEA.SWEA3;

/*
 * 순열로 순서 정하고 추를 올릴때마다 무게를 비교하는 함수
 */

import java.io.*;
import java.util.*;

public class SWEA_3234_준환이의양팔저울 {
	static int Ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			permutation(new int[N], 0, 0, arr);
			System.out.println("#"+tc+" "+Ans);
		}
	}

	private static void permutation(int[] sel, int k, int flag, int[] arr) {
		if(k == sel.length) {
			solve(sel, 0, 0, 0);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if( (flag & (1 << i)) > 0) continue;
			sel[k] = arr[i];
			permutation(sel, k+1, flag | (1<<i), arr);
		}
	}

	private static void solve(int[] sel, int idx, int A, int B) {
		if(sel.length == idx) {
			Ans++;
			return;
		}
		if(B+sel[idx]<=A) solve(sel, idx+1, A, B+sel[idx]);
		solve(sel, idx+1, A+sel[idx], B);
	}
}
