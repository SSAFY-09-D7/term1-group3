package BOJ_3;

import java.util.*;

import java.io.*;

public class Boj_12851_숨바꼭질2 {

	static int N, K, Cnt, Ans = Integer.MAX_VALUE;
	static int[] v = new int[100001];
	public static void main(String[] args) throws Exception{
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.MAX_VALUE;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v[N] = 0; 
		bfs();
		System.out.println(Ans);
		System.out.println(Cnt);
	}


	private static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(N, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == K) {
				if(Ans > p.time) {
					Ans = p.time;
					Cnt = 1;
				}
				else if (Ans == p.time) {
					Cnt++;
				}
			}
			if(p.x+1 <= 100000  && v[p.x+1] >= p.time+1) {
				v[p.x+1] = Math.min(Ans, p.time+1);
				queue.offer(new Point(p.x+1, p.time+1));
			}
			if(p.x-1 >= 0  && v[p.x-1] >= p.time+1) {
				v[p.x-1] = Math.min(Ans, p.time+1);
				queue.offer(new Point(p.x-1, p.time+1));
			}
			if(p.x*2 <= 100000  && v[p.x*2] >= p.time+1) {
				v[p.x*2] = Math.min(Ans, p.time+1);
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
