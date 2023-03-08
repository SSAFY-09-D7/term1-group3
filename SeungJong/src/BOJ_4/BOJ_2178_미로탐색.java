package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_2178_미로탐색 {
	static int N, M;
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
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
	}
	private static void bfs() {
		Queue<Point>queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1));
		v[0][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>= M || v[nr][nc] || map[nr][nc]==0) continue;
				if(nr == N-1 && nc == M-1) {
					System.out.println(p.cnt+1);
					return;
				}
				v[nr][nc] = true;
				queue.offer(new Point(nr, nc, p.cnt+1));
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
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
