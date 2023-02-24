package BOJ_3;

import java.util.*;
import java.io.*;

public class Boj_10026_적록색약 {

	static int N, Ans1, Ans2, Cnt1, Cnt2;
	static char[][] map;
	static boolean[][] v1;
	static boolean[][] v2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v1 = new boolean[N][N];
		v2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		/*
		 * 적색과 녹색은 같은 취급
		 * 문제가 이상하네 
		 * 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
		 * 이게 뭔소린지.. 그냥 신경 안쓰고 풀었는데 통과
		 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v1[i][j]) {
					v1[i][j] = true;
					Cnt1 = 1;
					bfs1(i, j);
					Ans1++;
				}
				if(!v2[i][j]) {
					v2[i][j] = true;
					Cnt2 = 1;
					bfs2(i, j);
					Ans2++;
				}
			}
		}
		System.out.println(Ans1+" "+Ans2);	
	}
	
	private static void bfs2(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, map[r][c]));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v2[nr][nc]) continue;
				if(p.val == 'R' || p.val == 'G') {
					if(map[nr][nc] == 'R' || map[nr][nc] == 'G') {
						v2[nr][nc] = true;
						Cnt2++;
						queue.offer(new Point(nr, nc, map[nr][nc]));
					}
				}
				else {
					if(map[nr][nc] == p.val) {
						v2[nr][nc] = true;
						Cnt2++;
						queue.offer(new Point(nr, nc, p.val));
					}
				}
			}
		}
	}

	private static void bfs1(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, map[r][c]));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v1[nr][nc]) continue;
				if(map[nr][nc] == p.val) {
					v1[nr][nc] = true;
					Cnt1++;
					queue.offer(new Point(nr, nc, p.val));
				}
			}
		}
	}

	private static class Point{
		int r, c;
		char val;
	
		public Point(int r, int c, char val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
