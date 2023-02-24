package BOJ_3;

import java.io.*;
import java.util.*;


public class Boj_2146_다리만들기 {

	static int N, Ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] v;
	static boolean[][] visit;
	static List<Point> loc;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] == 1) {
					v[i][j] = true;
					loc = new ArrayList<Point>();
					bfs1(i, j);
					for (int k = 0; k < loc.size(); k++) {
						visit = new boolean[N][N];
						visit[loc.get(k).r][loc.get(k).c] = true;
						bfs2(loc.get(k).r, loc.get(k).c);
					}
				}
			}
		}
		System.out.println(Ans);
	}
	private static void bfs2(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
			
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || v[nr][nc]) continue;
				if(map[p.r][p.c] == 1 && map[nr][nc] == 0) {
					visit[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.cnt+1));
				}
				if(map[p.r][p.c] == 0 && map[nr][nc] == 0 ) {
					visit[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.cnt+1));
				}
				if(map[p.r][p.c] == 0 && map[nr][nc] == 1) {
					Ans = Math.min(Ans, p.cnt);
					return;
				}
			}
		}	
	}
	
	private static void bfs1(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
				if(map[p.r][p.c] == 1 && map[nr][nc] == 1) {
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc, p.cnt+1));
				}
				if(map[p.r][p.c] == 1 && map[nr][nc] == 0) {
					if(!loc.contains(p)) loc.add(p);
				}
			}
		}		
	}
	
	private static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
