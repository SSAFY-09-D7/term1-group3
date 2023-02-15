package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_7733_치즈도둑 {

	static int N, Ans;
	static int count;
	static boolean[][] v;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
//			count = 0;
			Ans = 1;
			count = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max,  map[i][j]);
					min = Math.min(min,  map[i][j]);
				}
			}
			for (int i = min; i <= max; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(map[j][k] == i) {
							map[j][k] = 0;
						}
					}
				}
				count = 0;
				v = new boolean[N][N];
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(map[j][k] != 0 && v[j][k] == false) {
							bfs(j, k);
							count++;
						}
					}
				}
				Ans = Math.max(Ans,  count);
			}
			System.out.println("#"+tc+" "+Ans);
			
		}
	}
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c));
		v[r][c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc] || map[nr][nc] == 0) continue;
				v[nr][nc] = true;
				queue.offer(new Point(nr, nc));
			}
		}
	}
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
