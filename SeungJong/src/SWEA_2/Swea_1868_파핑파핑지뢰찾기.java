package SWEA_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea_1868_파핑파핑지뢰찾기 {

	static int N;
	static char[][] map;
	static boolean[][] v;
	static int[][] cntMap;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int count = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			cntMap = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						cntMap[i][j] = check8site(i,j);
					}else cntMap[i][j] = -1;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(cntMap[i][j] == 0 && v[i][j] == false) {
						v[i][j] = true;
						count++;
						bfs(i, j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(v[i][j] == false && cntMap[i][j] > 0) count++;
				}
			}
			System.out.println("#"+tc+" "+count);
			
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
				if(cntMap[nr][nc] == 0) {
					queue.offer(new Point(nr, nc));
				} 
				v[nr][nc] = true;
			}
			
		}
	}

	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	private static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	private static int check8site(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(map[nr][nc] == '*') cnt ++;
		}
		return cnt;
	}
}
