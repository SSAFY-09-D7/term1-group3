package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_17144_미세먼지안녕 {
	static int R, C, T, Ans;
	static int[][] map;
	static ArrayList<Integer> filter = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)  filter.add(i);
			}
		}
		for (int time = 0; time < T; time++) {
			Queue<Point> queue = new LinkedList<Point>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) queue.offer(new Point(i, j, map[i][j]));
				}
			}
			ArrayList<Point> list = new ArrayList<Point>();
			list = bfs(queue);
			for (int i = 0; i < list.size(); i++) {
				int r = list.get(i).r;
				int c = list.get(i).c;
				map[r][c] += list.get(i).val;
			}
			move();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					Ans += map[i][j];
				}
			}
		}
		System.out.println(Ans);
		
	}
	private static void move() {
		int r = filter.get(0)-1;
		
		int dir = 0;
		int c = 0;
		while(true) {
			if(r+dr[dir] < 0 || c+dc[dir] < 0 || r+dr[dir]>filter.get(0) || c+dc[dir]>=C) dir++; 
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			map[r][c] = map[nr][nc];
			r = nr;
			c = nc;
			if(dir==3 && nc ==1) {
				map[filter.get(0)][nc] = 0;
				break;
			}
		}
		r = filter.get(1)+1;
		c = 0;
		dir = 0;
		while(true) {
			if(r+dr2[dir] < filter.get(1) || c+dc2[dir] < 0 || r+dr2[dir]>=R || c+dc2[dir]>=C) dir++; 
			int nr = r + dr2[dir];
			int nc = c + dc2[dir];
			map[r][c] = map[nr][nc];
			r = nr;
			c = nc;
			if(dir==3 && nc ==1) {
				map[filter.get(1)][nc] = 0;
				break;
			}
		}
	}
	private static ArrayList<Point> bfs(Queue<Point> queue) {
		ArrayList<Point> list = new ArrayList<Point>();
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C ||map[nr][nc] == -1) continue;
				cnt++;
				list.add(new Point(nr, nc, p.val/5));
			}
			list.add(new Point(p.r, p.c, -(p.val/5)*cnt));
		}
		return list;
	}
	
	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
	}
	
	private static class Point{
		int r, c, val;

		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] dr2 = {1, 0, -1, 0};
	static int[] dc2 = {0, 1, 0, -1};
}
