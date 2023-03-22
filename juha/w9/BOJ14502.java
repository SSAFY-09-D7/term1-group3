package w8;

import java.io.*;
import java.util.*;

public class BOJ14502 {
	static int N, M, zerocnt, mincnt;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w8/BOJ14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		zerocnt = 0;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zerocnt++;
			}
		}
		mincnt = Integer.MAX_VALUE;
		makeWall(0);
		System.out.println(zerocnt-mincnt-3);
	}

	private static void makeWall(int cnt) {
		if(cnt == 3) {
			findZero();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt+1);
					map[i][j] = 0;
				}
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
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	private static void findZero() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] v = new boolean[map.length][map[0].length];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 2) {
					queue.offer(new Point(i, j));
					v[i][j] = true;
				}
			}
		}
		int cnt = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d = 0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >= 0 && nr < map.length && nc >=0 && nc<map[nr].length && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					cnt++;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		mincnt = Math.min(mincnt, cnt);
	}

}
