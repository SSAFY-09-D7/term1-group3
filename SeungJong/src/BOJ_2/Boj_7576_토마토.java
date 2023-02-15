package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576_토마토 {

	static int N, M;
	static int[][] map;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> queue = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					queue.offer(new Point(i, j, 0));
				}
			}
		}
		bfs(queue);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(count);
	}
	private static void bfs(Queue<Point> queue) {
		boolean v[][] = new boolean[N][M];
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			v[p.r][p.c] = true;
			map[p.r][p.c] = 1;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] != 0) continue;
				v[nr][nc] = true;
				map[nr][nc] = 1;
				queue.offer(new Point(nr, nc, p.cnt+1));
				count = Math.max(count, p.cnt+1);
			}
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}

}
