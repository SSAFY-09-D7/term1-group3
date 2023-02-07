package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1247_최적경로 {

	static int min;
	static int[][] arr;
	static int[][] start;
	static int[][] finish;
	static int[][] route;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			start = new int[1][2];
			finish = new int[1][2];
			route = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0][0] = Integer.parseInt(st.nextToken());
			start[0][1] = Integer.parseInt(st.nextToken());
			finish[0][0] = Integer.parseInt(st.nextToken());
			finish[0][1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					route[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			recursive(new int[N], 0, new boolean[N]);
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void recursive(int[] sel, int k, boolean[] v) {
		if(k==sel.length) {
			int distance = 0;
			for (int i = 0; i < N-1; i++) {
				int tmp = sel[i];
				int nextTmp = sel[i+1];
				distance += Math.abs(route[tmp][0] - route[nextTmp][0]) + Math.abs(route[tmp][1] - route[nextTmp][1]);
			}
			distance += Math.abs(start[0][0] - route[sel[0]][0]) + Math.abs(start[0][1] - route[sel[0]][1]);
			distance += Math.abs(route[sel[N-1]][0] - finish[0][0]) + Math.abs(route[sel[N-1]][1] - finish[0][1]);
			min = Math.min(distance, min);
			return;
		}
		for (int j = 0; j < N; j++) {
			if(!v[j]) {
				v[j] = true;
				sel[k]=j;
				recursive(sel, k+1, v);
				v[j] = false;
			}
		}
	}

}
