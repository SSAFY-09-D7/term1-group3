package w17;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(N, 0));
		boolean[] visited = new boolean[100001];
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visited[p.x] = true;
			
			if (p.x == K) answer = Math.min(answer, p.cnt);
			
			if (p.x * 2 < 100001 && !visited[p.x * 2]) q.add(new Point(p.x * 2, p.cnt));
			if (p.x + 1 < 100001 && !visited[p.x + 1]) q.add(new Point(p.x + 1, p.cnt + 1));
			if (p.x - 1 >= 0 && !visited[p.x - 1]) q.add(new Point(p.x - 1, p.cnt + 1));
		}
		
		System.out.println(answer);
	}
	
	static class Point {
		int x, cnt;

		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
}
