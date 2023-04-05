package BOJ.BOJ5;

/*
 * 물 : *
 * 돌 : X
 * 빈칸 : .
 * 동굴 : D
 * 고슴도치 : S
 */

import java.io.*;
import java.util.*;

public class BOJ_3055_탈출 {
	static int R, C, Ans = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][][] v;
	static Queue<Point> queue = new LinkedList<Point>();
	static Queue<Point> water = new LinkedList<Point>();
	static Point endPosition;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C][2];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					queue.offer(new Point(i, j, 0));
					v[i][j][0] = true;
				}
				else if(map[i][j] == '*') {
					water.offer(new Point(i, j, 0));
					v[i][j][1] = true;
				}
				else if(map[i][j] == 'D') endPosition = new Point(i, j, 0);
			}
		}
		bfs();
		System.out.println(Ans==Integer.MAX_VALUE?"KAKTUS":Ans);
	}
	private static void bfs() {
		while(true) {
			int sizeWater = water.size();
			for (int s = 0; s < sizeWater; s++) {
				Point w = water.poll();
				for (int i = 0; i < 4; i++) {
					int nr = w.r + dr[i];
					int nc = w.c + dc[i];
					if(nr<0 || nc<0 | nr>=R || nc>=C || v[nr][nc][1]) continue;
					if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
						v[nr][nc][1] = true;
						map[nr][nc] = '*';
						water.offer(new Point(nr, nc, w.cnt+1));
					}
				}
				
			}
			int sizeS = queue.size();
			for (int d = 0; d < sizeS; d++) {
				Point s = queue.poll();
				if(s.r == endPosition.r && s.c == endPosition.c) {
					Ans = s.cnt;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nr = s.r + dr[i];
					int nc = s.c + dc[i];
					if(nr<0 || nc<0 | nr>=R || nc>=C || v[nr][nc][0]) continue;
					if(map[nr][nc] == '.' || map[nr][nc] == 'D') {
						v[nr][nc][0] = true;
						map[nr][nc] = 'S';
						queue.offer(new Point(nr, nc, s.cnt+1));
					}
				}
			}
			if(queue.isEmpty()) return;
		}
	}
	private static class Point{
		int r, c, cnt;
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
