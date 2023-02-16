package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1303_전쟁전투 {

	static int N, M;
	static char[][] map;
	static boolean[][] v;
	static int Ans1, Ans2, temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j] == false) {
					temp = 1;
					dfs(i, j, map[i][j]);
					if(map[i][j] == 'W') Ans1 += (int)Math.pow(temp, 2);
					else Ans2 += (int)Math.pow(temp, 2);
				}
			}
		}	
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if(v[i][j] == false) {
//					temp = 1;
//					bfs(i, j, map[i][j]);
//					if(map[i][j] == 'W') Ans1 += (int)Math.pow(temp, 2);
//					else Ans2 += (int)Math.pow(temp, 2);
//				}
//			}
//		}	
		System.out.println(Ans1 + " "+ Ans2);
	}
	
	private static void bfs(int r, int c, char val) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, 1));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			v[p.r][p.c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];			
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(!v[nr][nc] &&  map[nr][nc] == val) {
					queue.offer(new Point(nr, nc, p.cnt+1));
					v[nr][nc] = true;
					temp++;
				}
			}
		}
	}
	
	private static void dfs(int r, int c, char val) {
		v[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(!v[nr][nc] && map[nr][nc] == val) {
				v[nr][nc] = true;
				dfs(nr, nc, val);
				temp++;
			}
		}
	}

	public static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
}
