package w10;

import java.util.*;
import java.io.*;

public class Main {
	static int T, N;
	static int[][] points;
	static int[] startPoint, endPoint;
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ9205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new int[N][2];
			
			st = new StringTokenizer(br.readLine());
			startPoint = new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
						
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			endPoint = new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		
			System.out.println(bfs());
		}
	}
	
	private static String bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startPoint[0], startPoint[1], 20));
		boolean visited[] = new boolean[N];
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int dis = Math.abs(endPoint[0] - p.r) + Math.abs(endPoint[1] - p.c);
			if (dis <= 1000) {
				return "happy";
			}
			
			for (int i = 0; i < N; i++) {
				if (visited[i]) continue;
				dis = Math.abs(points[i][0] - p.r) + Math.abs(points[i][1] - p.c);
				
				if (dis <= 1000) {
					visited[i] = true;
					q.add(new Point(points[i][0], points[i][1], 20));
				}
			}
		}
		
		return "sad";
	}
	
	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
