package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_9205_맥주마시면서걸어가기 {
	static int N, Ans;
	static Point[] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new Point[N+2];
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i] = new Point(x, y);
			}
			bfs(0);
			sb.append(Ans==1?"happy\n":"sad\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int start) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(map[start]);
		boolean[] v = new boolean[N+2];
		v[start] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.r == map[N+1].r && p.c == map[N+1].c) {
				Ans = 1;
				return;
			}
			for (int i = 0; i < map.length; i++) {
				if(!v[i]) {
					int disR = Math.abs(p.r - map[i].r);
					int disC = Math.abs(p.c - map[i].c);
					int dis = Math.abs(disR + disC);
					if(dis <= 1000) {
						v[i] = true;
						queue.offer(map[i]);
					}
				}
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
}
