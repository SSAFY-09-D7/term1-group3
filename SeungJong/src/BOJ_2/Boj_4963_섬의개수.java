package BOJ_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4963_섬의개수 {

	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_boj4963.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			map = new int[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
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
		queue.offer(new Point(r, c));
		boolean v[][] = new boolean [N][M];
		v[r][c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c] = 0;
			for (int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] == 0) continue;
				queue.offer(new Point(nr, nc));
				v[nr][nc] = true;
			}
		}
	}

	public static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	

}
