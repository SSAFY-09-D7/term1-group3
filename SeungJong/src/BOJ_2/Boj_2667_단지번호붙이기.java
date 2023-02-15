package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



public class Boj_2667_단지번호붙이기 {

	static int[][] map;
	static int N;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					count++;
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean v[][] = new boolean[N][N];
		v[r][c] = true;
		queue.offer(new Point(r, c));
		int val = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.r][p.c] = 0;
			val++;
			for (int i = 0; i < dr.length; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc] || map[nr][nc] == 0) continue; 
				queue.offer(new Point(nr, nc));
				v[nr][nc] = true;
			}
		}
		list.add(val);
	}
	static class Point{
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
