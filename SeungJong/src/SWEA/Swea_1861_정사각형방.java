package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1861_정사각형방 {

	static int N;
	static int[][] map;
	static int Ans;
	static int Index;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./input/input_swea1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			Index = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					dfs(i, j, map[i][j], 1, map[i][j]);
					bfs(i, j, 1, map[i][j], map[i][j]);
				}
			}
//			dfs(0, 0, map[0][0], 1);
			System.out.println("#"+tc+" "+ Index+" " + Ans);
		}
	}
	
	private static void bfs(int r, int c, int cnt, int val, int index) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] v = new boolean [N][N];
		queue.offer(new Point(r, c, cnt, map[r][c], index));
		v[r][c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
//			Ans = Math.max(Ans,  p.cnt);
			if(Ans < p.cnt) {
//				System.out.println(p.cnt+" " + index);
				Ans = p.cnt;
//				if(Index > p.index) Index = p.index;
				Index = index;
			}
			else if(Ans == p.cnt) {
				if(Index > index) Index = index;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
				if(p.val+1 == map[nr][nc]) {
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.cnt+1, map[nr][nc] ,index));
//					Ans = Math.max(Ans, p.cnt+1);
				}
			}
		}
	}
	
	private static void dfs(int r, int c, int val, int cnt, int index) {
		boolean[][] v = new boolean[N][N];
		if(r == N && c == N) {
			System.out.println("r c "+ r+" "+c);
			return;
		}
//		Ans = Math.max(Ans, cnt);

		if(cnt >= Ans ) {
			Ans = cnt;
			if(Index > index)
			Index = index;
		}

		v[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
			if(map[nr][nc] == val+1) {
				v[nr][nc] = true;
				dfs(nr, nc, map[nr][nc], cnt+1, index);
			}
		}
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static class Point {
		int r, c, cnt, val, index;

		public Point(int r, int c, int cnt, int val, int index) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.val = val;
			this.index = index;
		}
	}
}
