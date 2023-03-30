package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_1194_달이차오른다가자 {
	static int N, M, Ans;
	static char[][] map;
	static boolean[][][] v;
	static Queue<Point> queue = new LinkedList<Point>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M][64];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					queue.offer(new Point(i, j, 0, 0));
					v[i][j][0] = true;
				}
			}
		}
		bfs();
		System.out.println(Ans==0?-1:Ans);
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(map[p.r][p.c] == '1') {
				Ans = p.cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc][p.k] || map[nr][nc] == '#') continue;
				if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
					int index = map[nr][nc] - 'a';
					int key = p.k | (1 << index);
					v[nr][nc][key] = true;
					queue.offer(new Point(nr, nc, p.cnt+1, key));
				}
				else if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
					int index = map[nr][nc] - 'A';
					if((p.k & (1 << index)) > 0 ) {
						v[nr][nc][p.k] = true;
						queue.offer(new Point(nr, nc, p.cnt+1, p.k));
					}
				}
				else {
					v[nr][nc][p.k] = true;
					queue.offer(new Point(nr, nc, p.cnt+1, p.k));
				}
			}
		}
	}
	private static class Point{
		int r, c, cnt, k;
		public Point(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", k=" + k + "]";
		}
		
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
