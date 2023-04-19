package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_1261_알고스팟 {
	static int N, M, Ans;
	static int[][] map;
	static boolean[][] v;
	static int[][] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dijkstra();
		System.out.println(Ans);
	}
	
	private static void dijkstra() {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		dist[0][0] = 0;
		queue.add(new Point(0, 0, map[0][0]));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(!v[p.r][p.c]) {
				v[p.r][p.c] = true; 
				if(p.r == N-1 && p.c == M-1) {
					Ans = p.val;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc]) continue;
					if(dist[nr][nc] > dist[p.r][p.c] + map[nr][nc]) {
						dist[nr][nc] = dist[p.r][p.c] + map[nr][nc];
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
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", val=" + val + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
