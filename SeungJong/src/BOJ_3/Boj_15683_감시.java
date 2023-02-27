package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_15683_감시 {

	static int N, M, mapArea, Cnt;
	static int[][] map;
	static List<Point> list = new ArrayList<Point>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=1 && map[i][j] <= 5) {
					list.add(new Point(i, j, map[i][j]));
				} else if(map[i][j] == 0) mapArea++;
			}
		}
		List<Point> temp = new ArrayList<Point>();
		solve(0, 0, map);
//		System.out.println(mapArea);
//		System.out.println(Cnt);
		System.out.println(mapArea-Cnt);

	}
	private static void solve(int size, int cnt, int[][] map) {
		if(size == list.size()) {
			Cnt = Math.max(Cnt,  cnt);
			return;
		}
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		int r = list.get(size).r;
		int c = list.get(size).c;
		int type = list.get(size).type;
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			for (int j : camDir[type]) {
				int k = 1;
				while(true) {
					int nr = r + (dr[(j+i)%4])*k;
					int nc = c + (dc[(j+i)%4])*k;
					if(nr < 0 || nc < 0 || nr >= N || nc >= M || tempMap[nr][nc] == 6 ) break;
					else if(tempMap[nr][nc] == 0) {
						tempMap[nr][nc] = -1;
//						System.out.println("r c " + r+" " + c);
//						System.out.println("nr nc " + nr+" " + nc);
						sum++;
//						temp.add(new Point(nr, nc, type));
					}
					k++;
				}
//				System.out.println(temp);
			}
//			System.out.println(cnt+sum);
//			print(tempMap);
//			System.out.println();
			solve(size+1, cnt+sum, tempMap);
			tempMap = new int[N][M];
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < M; j++) {
					tempMap[k][j] = map[k][j];
				}
			}
//			print(tempMap);
//			System.out.println();
		}	
	}
	
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static class Point{
		int r, c, type;

		public Point(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", type=" + type + "]";
		}
		
		
		
	}
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] camDir = {{},{0},{0,2},{0,3},{0,1,2},{0,1,2,3}};

}
