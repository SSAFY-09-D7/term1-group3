package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_14500_테트로미노 {
	static int N, M, Ans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				solve(i, j, 1, map[i][j]);
				v[i][j] = false;
			}
		}
		System.out.println(Ans);
	}
	private static void solve(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			Ans = Math.max(Ans, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc]) continue;
			v[nr][nc] = true;
			if(cnt==1) {
				for (int i = 0; i < 4; i++) {
					int nnr = nr + dr[i];
					int nnc = nc + dc[i];
					if(nnr<0 || nnc<0 || nnr>=N || nnc>=M || v[nnr][nnc]) continue;
					v[nnr][nnc] = true;
					solve(nr, nc, cnt+2, sum+map[nnr][nnc]+map[nr][nc]);
					v[nnr][nnc] = false;
				}
			}
			solve(nr, nc, cnt+1, sum+map[nr][nc]);
			v[nr][nc] = false;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
