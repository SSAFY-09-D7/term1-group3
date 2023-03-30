package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_4485_녹색옷입은애가젤다지 {
	static int N, Ans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			Ans = Integer.MAX_VALUE;
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			sb.append("Problem "+tc+": "+Ans+"\n");
			tc++;
		}
		System.out.println(sb.toString());
		

	}
	private static void dijkstra() {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.offer(new Point(0, 0, map[0][0]));
		int[][] dist = new int[N][N];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = map[0][0];
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(!v[p.r][p.c]) {
				v[p.r][p.c] = true; 
				if(p.r == N-1 && p.c == N-1) {
					Ans = Math.min(Ans, p.val);
				}
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
					if(dist[nr][nc] > p.val+map[nr][nc]) {
						dist[nr][nc] = p.val+map[nr][nc];
						queue.offer(new Point(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
	}
	private static class Point implements Comparable<Point>{
		int r, c, val;
		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
