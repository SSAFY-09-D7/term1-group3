package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_1600_말이되고픈원숭이 {
	static int N, M, K, Ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(Ans!=Integer.MAX_VALUE?Ans:-1);
	}
	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, K, 0));
		v[0][0][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r == N-1 && p.c == M-1) {
				Ans = Math.min(Ans, p.cnt);
				return;
			}

			for (int i = 0; i < 12; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(i<4) {
					if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc][p.k] || map[nr][nc]==1) continue;
					v[nr][nc][p.k] = true;
					queue.offer(new Point(nr, nc, p.k, p.cnt+1));
				}
				else {
					if(p.k>0) {
						if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc][p.k-1] || map[nr][nc]==1) continue;
						v[nr][nc][p.k-1] = true;
						queue.offer(new Point(nr, nc, p.k-1, p.cnt+1));
					}
				}
			}
		}
	}
	private static class Point{
		int r, c, k, cnt;
		public Point(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}
	static int[] dr = {-1, 1, 0, 0, -2,-1,1,2,2,1,-1,-2};
	static int[] dc = {0, 0, -1, 1, 1,2,2,1,-1,-2,-2,-1};
}
