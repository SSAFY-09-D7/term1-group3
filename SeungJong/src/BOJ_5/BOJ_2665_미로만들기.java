package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_2665_미로만들기 {

	static int N, Ans;
	static int[][] map;
	static int[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Ans = Integer.MAX_VALUE;
		map = new int[N][N];
		v = new int [N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
				v[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(Ans);
	}
	
	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 0));
		v[0][0] = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.r == N-1 && p.c == N-1) {
				Ans = Math.min(Ans, p.cnt);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr<0 || nc<0 || nr>= N || nc>= N || v[nr][nc] <= p.cnt || p.cnt >= Ans) continue;
				int visit = p.cnt;
				if(map[nr][nc] == 0) visit++;
				v[nr][nc] = visit; 
				queue.offer(new Point(nr, nc, visit));
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
