package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_14502_연구소 {
	static int N, M, Ans;
	static int blankCnt;
	static int[][] map;
	static Queue<Point> queue = new LinkedList<Point>();
	static ArrayList<Point> virus = new ArrayList<Point>();
	static ArrayList<Point> blank = new ArrayList<Point>();
	static ArrayList<Point> rollBack;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new Point(i, j));
				else if(map[i][j] == 0) blank.add(new Point(i, j));
			}
		}
		blankCnt = blank.size();
		solve(0, 0);
		System.out.println(Ans);
	}
	private static void solve(int index, int cnt) {
		if(cnt == 3) {
			rollBack =  new ArrayList<Point>();
			bfs();
			Ans = Math.max(Ans, check());
			for (int i = 0; i < rollBack.size(); i++) {
				int r = rollBack.get(i).r;
				int c = rollBack.get(i).c;
				map[r][c] = 0;
			}
			return;
		}
		if(index == blankCnt) return;
		int r = blank.get(index).r;
		int c = blank.get(index).c;
		map[r][c] = 1;
		solve(index+1, cnt+1);
		map[r][c] = 0;
		solve(index+1, cnt);
	}
	private static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	private static void bfs() {
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
		}
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 0) continue;
				map[nr][nc] = 2;
				rollBack.add(new Point(nr, nc));
				queue.offer(new Point(nr, nc));
			}
		}
	}
	private static class Point{
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
