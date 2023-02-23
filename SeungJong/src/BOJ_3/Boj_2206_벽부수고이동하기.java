package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_2206_벽부수고이동하기 {

	static int N, M;
	static int[][] map;
	static boolean[][] vBreak;
	static boolean[][] vNotBreak;
	static boolean[][][] v;
	static int Ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		vBreak = new boolean[N][M];
		vNotBreak = new boolean[N][M];
		v = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs(0, 0);
		System.out.println(Ans!=Integer.MAX_VALUE?Ans:-1);
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, 1, false));
		vNotBreak[r][c] = true;
		v[0][0][0] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.cnt >= Ans) continue;
			if(p.r == N-1 && p.c == M-1) {
				Ans = Math.min(Ans,  p.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				// 3차원 방문배열
				if(p.check) {
					if(map[nr][nc] == 0 && !v[nr][nc][1]) {
						v[nr][nc][1] = true;
						queue.offer(new Point(nr,nc,p.cnt+1, true));						
					}
				}
				else {
					if(map[nr][nc] == 0 && !v[nr][nc][0]) {
						v[nr][nc][0] = true;
						queue.offer(new Point(nr,nc,p.cnt+1, p.check));						
					}
					else {
						if(map[nr][nc] == 1 && !v[nr][nc][1]) {
							v[nr][nc][1] = true;
							queue.offer(new Point(nr,nc,p.cnt+1, true));						
						}
					}
				}

				// 방문배열 두개
//				if(p.check) {
//					if(map[nr][nc] == 0 && !vBreak[nr][nc]) {
//						vBreak[nr][nc] = true;
//						queue.offer(new Point(nr,nc,p.cnt+1, true));						
//					}
//				}
//				else {
//					if(map[nr][nc] == 0 && !vNotBreak[nr][nc]) {
//						vNotBreak[nr][nc] = true;
//						vBreak[nr][nc] = true;
//						queue.offer(new Point(nr,nc,p.cnt+1, false));
//					}
//					if(map[nr][nc] == 1 && !vBreak[nr][nc]) {
//						vBreak[nr][nc] = true;
//						queue.offer(new Point(nr,nc,p.cnt+1, true));
//					}
//				}
			}
		}
	}

	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static class Point{
		int r, c, cnt;
		boolean check;
		
		public Point(int r, int c, int cnt, boolean check) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.check = check;
		}	
	}
}
