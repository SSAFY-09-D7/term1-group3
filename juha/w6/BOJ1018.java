package com.w6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1018 {
	static int N, M, changeMin;
	static char[][] map;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ1018.txt"));
		//Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		for(int i = 0;i<N;i++) {
			String s = sc.next();
			for(int j = 0;j<M;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		changeMin = Integer.MAX_VALUE;
		for(int i = 0;i<=N-8;i++) {
			for(int j = 0;j<=M-8;j++) {
				bfs(i, j);
				bfs2(i, j);
			}
		}
		System.out.println(changeMin);
	}

	private static void bfs2(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		int cnt = 0;
		
		queue.offer(new Point(r, c, true));
		if(map[r][c] == 'W') {
			map[r][c] = 'B';
		}else map[r][c] = 'W';
		v[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d = 0;d<4;d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr>=r && nr<r+8 && nc>=c && nc<c+8 && !v[nr][nc]) {
					
					v[nr][nc] = true;
					if(map[p.r][p.c] == 'W') {
						if(map[nr][nc] == 'B') {
							queue.offer(new Point(nr, nc, false));
						}else {
							map[nr][nc] = 'B';
							queue.offer(new Point(nr, nc, true));
						}
					}else {
						if(map[nr][nc] == 'W') {
							queue.offer(new Point(nr, nc, false));
						}else {
							map[nr][nc] = 'W';
							queue.offer(new Point(nr, nc, true));
						}
					}
				}
			}
			if(p.change) {
				cnt++;
				if(map[p.r][p.c] == 'W') {
					map[p.r][p.c] = 'B';
				}else map[p.r][p.c] = 'W';
			}
		}
		changeMin = Math.min(changeMin, cnt);
	}

	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	
	static class Point{
		int r, c;
		boolean change;

		public Point(int r, int c, boolean change) {
			super();
			this.r = r;
			this.c = c;
			this.change = change;
		}
		
	}
	
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		int cnt = 0;
		
		queue.offer(new Point(r, c, false));
		v[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d = 0;d<4;d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr>=r && nr<r+8 && nc>=c && nc<c+8 && !v[nr][nc]) {
					v[nr][nc] = true;
					if(map[p.r][p.c] == 'W') {
						if(map[nr][nc] == 'B') {
							queue.offer(new Point(nr, nc, false));
						}else {
							map[nr][nc] = 'B';
							queue.offer(new Point(nr, nc, true));
						}
					}else {
						if(map[nr][nc] == 'W') {
							queue.offer(new Point(nr, nc, false));
						}else {
							map[nr][nc] = 'W';
							queue.offer(new Point(nr, nc, true));
						}
					}
				}
			}
			if(p.change) {
				cnt++;
				if(map[p.r][p.c] == 'W') {
					map[p.r][p.c] = 'B';
				}else map[p.r][p.c] = 'W';
			}
		}		
		changeMin = Math.min(changeMin, cnt);
				
	}

}
