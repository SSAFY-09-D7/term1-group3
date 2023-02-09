package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4 {

	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		combination(new int[M], 1, 0);
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = idx; i <= N; i++) {
			sel[k] = i;
			combination(sel, i, k+1);
		}
	}

}
