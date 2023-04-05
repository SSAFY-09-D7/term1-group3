package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_1941_소문난칠공주 {
	static char[][] map = new char[5][5];
	static boolean[][] v;
	static ArrayList<Point> list = new ArrayList<Point>();
	static int Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				list.add(new Point(i, j));
			}
		}
		combination(new Point[7], 0, 0);
		System.out.println(Ans);
		
	}
	private static void combination(Point[] sel, int idx, int k) {
		if(k==sel.length) {
			v = new boolean[5][5];
			bfs(sel);
			return;
		}
		for (int i = idx; i < list.size(); i++) {
			sel[k] = list.get(i);
			combination(sel, i+1, k+1);
		}
	}
	private static void bfs(Point[] sel) {
		Queue<Point>queue = new LinkedList<Point>();
		Point a = sel[0];
		v[a.r][a.c]= true;
		queue.offer(a);
		int link = 1;
		int countS = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(map[p.r][p.c] == 'S') countS++;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr<0 || nc<0 || nr>=5 || nc>=5 || v[nr][nc]) continue;
				for (int j = 1; j < 7; j++) {
					if(sel[j].r == nr && sel[j].c == nc) {
						v[nr][nc] = true;
						link++;
						queue.offer(new Point(nr, nc));
					}
				}
			}
		}
		if(link>=7) {
			if(countS>=4) Ans++;
		}
	}


	private static class Point{
		int r, c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;

		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
