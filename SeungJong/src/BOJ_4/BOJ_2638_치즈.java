package BOJ.BOJ4;

import java.io.*;
import java.util.*;

/*
 * 1. 내부 공간과 외부 공간을 구분해야함.
 * 		빈 공간일 때 BFS 돌려서 외곽을 만난다면 외부
 * 		외부를 만나지 못한다면 내부
 * 2. 외부라면 빈 공간을 다른 값으로 바꾼다
 * 		치즈에서 사방탐색을 해서 외부가 두번이상 만난다면 외부 값으로 바꾼다
 * 3. 치즈가 없다면 끝
 */
public class BOJ_2638_치즈 {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Point> cheese = new ArrayList<Point>();
	static ArrayList<Point> outside;
	static boolean skip;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese.add(new Point(i, j));
			}
		}
		int Ans = 0;
		while(cheese.size()>0) {
			Ans++;
			// 외부공간과 내부공간을 나눈다.
			// 외부공간을 -1로 하여 반복할때마다 0인 지점들이 내부인지 외부인지 확인한다.
			// 만약 내부공간이 남아있지 않다면 스킵하도록 한다.
			if(!skip) {
				int innerCnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(map[i][j] == 0) {
							flag = false;
							outside = new ArrayList<Point>();
							v = new boolean[N][M];
							bfs(i, j);
							if(flag) {
								for (Point p : outside) {
									map[p.r][p.c] = 2; 
								}
								innerCnt++;
							}
						}
					}
				}
				if(innerCnt==0) skip = true;
			}
//			print();
//			System.out.println();
			ArrayList<Point> change = new ArrayList<Point>();
			for (Point p : cheese) {
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					
					if(map[nr][nc] == 2) cnt++;
				}
				if(cnt>=2) change.add(p);
			}
			for (Point point : change) {
				cheese.remove(point);
				map[point.r][point.c] = 2; 
			}
//			print();
//			System.out.println();
//			for (Point point : cheese) {
//				System.out.println(point.r+" "+point.c);
//			}
		}
		System.out.println(Ans);
	}


	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c));
		v[r][c] = true;
//		map[r][c] = -1;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if(map[p.r][p.c] == 0 )outside.add(p);
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 2) {
					flag = true;
					continue;
				}
				if (!v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
