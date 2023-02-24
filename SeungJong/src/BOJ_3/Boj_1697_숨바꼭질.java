package BOJ_3;

import java.util.*;
import java.io.*;

public class Boj_1697_숨바꼭질 {

	static int N, K, Ans = Integer.MAX_VALUE;
	static boolean[] v = new boolean[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(Ans);
	}
	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(N, 0));
		v[N] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == K) {
				Ans = p.time;
				return;
			}
			if(p.x+1 <= 100000 && !v[p.x+1]) {
				v[p.x+1] = true;
				queue.offer(new Point(p.x+1, p.time+1));
			}
			if(p.x-1 >= 0 && !v[p.x-1]) {
				v[p.x-1] = true;
				queue.offer(new Point(p.x-1, p.time+1));
			}
			if(p.x*2 <= 100000 && !v[p.x*2]) {
				v[p.x*2] = true;
				queue.offer(new Point(p.x*2, p.time+1));
			}
		}
	}
	
	private static class Point{
		int x, time;

		public Point(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
		
	}
}
