package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj_1012_유기농배추 {

	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			int count = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						count++;
						bfs(i, j);
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean v[][] = new boolean[N][M];
		v[r][c] = true;
		queue.offer(new Point(r, c));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c] = 0;
			for (int i = 0; i < dr.length; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] == 0) continue; 
				queue.offer(new Point(nr, nc));
				v[nr][nc] = true;
			}
		}
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
