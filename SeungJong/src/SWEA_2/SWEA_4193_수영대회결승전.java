package SWEA.SWEA2;

import java.io.*;
import java.util.*;

public class SWEA_4193_수영대회결승전 {
	static int N, Ans;
	static int[][] map;
	static boolean[][] v;
	static int endR, endC;
	static Queue<Point> queue = new LinkedList<Point>();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea4193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			queue.clear();
			Ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			queue.offer(new Point(r, c, 0));
			v[r][c] = true;
//			if(tc == 2)
			bfs();
			Ans = Ans==Integer.MAX_VALUE?-1:Ans;
			System.out.println("#"+tc+" "+Ans);
		}
	}
	// cnt % 3 == 2
	private static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
//			System.out.println(p+" "+map[p.r][p.c]);
			if(p.r == endR && p.c == endC) {
				Ans = p.cnt;
				return;
			}
			if(p.cnt % 3 == 2 && map[p.r][p.c]== 2 ) {
				queue.offer(new Point(p.r, p.c, p.cnt+1));
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>= N || v[nr][nc] || map[nr][nc] == 1) continue;
				if(map[nr][nc] == 2) {
					if((p.cnt+1)%3 == 2 || p.cnt%3 == 2) {
						v[nr][nc] = true;
						queue.offer(new Point(nr, nc, p.cnt+1));
					}
					else queue.offer(new Point(p.r, p.c, p.cnt+1));
				}
				else {
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.cnt+1));
				}
			}
			
		}
	}
	private static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
