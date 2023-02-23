package SWEA_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1953_탈주범검거 {

	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] v;
	static int Ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./input/input_swea1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(R, C);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, map[r][c], 0));
		v[r][c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[map[p.r][p.c]-1][i];
				int nc = p.c + dc[map[p.r][p.c]-1][i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M ||v[nr][nc] || map[nr][nc] == 0) continue;
				for (int j = 0; j < 4; j++) {
					if(fourWay[i][j] == map[nr][nc]) {
						if(p.cnt +1< L) {
							v[nr][nc] = true;
							queue.offer(new Point(nr, nc, map[nr][nc], p.cnt+1));
							Ans++;
						}
					}
				}
			}
		
		}
	}
	
	static int[][] fourWay = {  // 상 하 좌 우 순서로 올 수 있는 터널의 모양(타입)
			{1,2,5,6}, {1,2,4,7}, {1,3,4,5},{1,3,6,7}
	};
	static int[][] dr = { // 7개의 타입 별 delta Row  상하좌우 순서
			{-1,1,0,0}, {-1,1,0,0}, {0,0,0,0}, {-1,0,0,0}, {0,1,0,0},{0,1,0,0},{-1,0,0,0}
	};
	static int[][] dc = { // 7개의 타입 별 delth Col 상하좌우 순서
			{0,0,-1,1}, {0,0,0,0}, {0,0,-1,1}, {0,0,0,1}, {0,0,0,1}, {0,0,-1,0}, {0,0,-1,0}
	};
	
	private static class Point{
		int r, c, dir, cnt;

		public Point(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

	}
}
