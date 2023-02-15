package com.w5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ17070 {
	static int[][] map;
	static int fcnt;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ17070.txt"));
		//Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		fcnt = 0;
		
		dfs();
		System.out.println(fcnt);
	}
	
	static class Point{
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}

	static int[][] dr = {{0,0,1}, {0,1,1}, {0,1,1}};
	static int[][] dc = {{1,0,1}, {0,0,1}, {1,0,1}};
	private static void dfs() {
		Stack<Point> queue = new Stack<>();
		queue.push(new Point(0, 1, 0));
		
		while(!queue.isEmpty()) {
			Point p = queue.pop();
			map[p.r][p.c] = 0;
			for(int d = 0;d<3;d++) {
				if(p.r != map.length-1 && p.c == map.length-2 && d == 0) continue;
				if(p.r == map.length-2 && p.c != map.length-1 && d == 1) continue;
				if(dr[p.dir][d] == 0 && dc[p.dir][d] == 0) continue;
				int nr = p.r + dr[p.dir][d];
				int nc = p.c + dc[p.dir][d];
				
				if(nr<map.length && nc<map[nr].length && map[nr][nc] == 0) {						
					if(d == 2) {
						if(map[p.r + dr[d][0]][p.c + dc[d][0]] == 0 && map[p.r + dr[d][1]][p.c + dc[d][1]] == 0) {
							queue.push(new Point(nr, nc, d));
						}else break;
					}else {
						queue.push(new Point(nr, nc, d));
					}
					if(nr==map.length-1 && nc ==map.length-1) fcnt++;
				}
			}
		}
		
	}
}
