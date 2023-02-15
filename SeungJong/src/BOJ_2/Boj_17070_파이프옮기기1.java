package BOJ_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17070_파이프옮기기1 {

	static int N;  // N-1, N-1 까지
	static int[][] map;
	static int Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// array[N-1][N-1]이 1인지 검사하는 코드를 추가해보세요
		if(map[N-1][N-1] == 1) {
			bw.write("0");
			bw.flush();
			return;
		}
		bfs();
		bw.write(Ans+"");
		bw.flush();
		
	}
	
	private static void bfs() {
		Stack<Point> queue = new Stack<Point>();
		queue.push(new Point(0, 1, 0));

		while(!queue.isEmpty()) {
			Point p = queue.pop();
			int nr = 0;
			int nc = 0;
			int count;
			if(p.r == N-1 && p.c == N-1) {
				Ans++;
			}
			switch (p.dir) {
			case 0:
				for (int i = 0; i < dr0.length; i++) {
					count = 0;
					for (int j = 0; j < dr0[i].length; j++) {
						nr = p.r + dr0[i][j];
						nc = p.c + dc0[i][j];
						if(nr == p.r && nc == p.c) continue; 
						if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1) continue;
						count++;
					}
					if(count == dr0[i].length) {
						queue.push(new Point(nr, nc, i));
					}
				}
				break;
			case 1:
				for (int i = 0; i < dr1.length; i++) {
					count = 0;
					for (int j = 0; j < dr1[i].length; j++) {
						nr = p.r + dr1[i][j];
						nc = p.c + dc1[i][j];
						if(nr == p.r && nc == p.c) continue; 
						if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1) continue;
						count++;
					}
					if(count == dr1[i].length) {
						queue.push(new Point(nr, nc, i));
					}
				}
				break;
			case 2:
				for (int i = 0; i < dr2.length; i++) {
					count = 0;
					for (int j = 0; j < dr2[i].length; j++) {
						nr = p.r + dr2[i][j];
						nc = p.c + dc2[i][j];
						if(nr == p.r && nc == p.c) continue; 
						if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1) continue;
						count++;
					}
					if(count == dr2[i].length) {
						queue.push(new Point(nr, nc, i));
					}
				}
				break;
			}
		}
	}

	/*
	 * 현재 Point의 dir을 확인하고
	 * 해당 dir이 갈 수 있는 방향을 체크 하고
	 * 그 방향이 맞다면 해당 좌표와 dir을 queue에 offer
	 * map[N-1][N-1] 에 값이 들어오면 ans++
	 */
	
	static int[][] dr0 = {{0}, {0}, {0, 1, 1}}; // 가로 세로 대각선
	static int[][] dc0 = {{1}, {0}, {1, 0, 1}};
	
	static int[][] dr1 = {{0}, {1}, {0, 1, 1}};
	static int[][] dc1 = {{0}, {0}, {1, 0, 1}};
	
	static int[][] dr2 = {{0}, {1}, {0, 1, 1}};
	static int[][] dc2 = {{1}, {0}, {1, 0, 1}};
	
	public static class Point{
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}	
		
	}
}
