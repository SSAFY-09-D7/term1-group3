package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_18428_감시피하기 {
	static int N;
	static char[][] map;
	static boolean Ans;
	static ArrayList<Point> list = new ArrayList<Point>();
	static ArrayList<Point> student = new ArrayList<Point>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'X') list.add(new Point(i, j));
				else if(map[i][j] == 'S') student.add(new Point(i, j));
			}
		}
		solve(0, 0);
		System.out.println("NO");
	}
	private static void solve(int cnt, int check) {
		if(cnt == list.size() || check == 3) {
			return;
		}
		int r = list.get(cnt).r;
		int c = list.get(cnt).c;
		map[r][c] = 'O';
		if(check+1 == 3) {
			checkAns();
		}
		solve(cnt + 1, check + 1);
		map[r][c] = 'X';
		solve(cnt + 1, check);
		
	}
	private static void checkAns() {
		for (Point p : student) {
			int r = p.r;
			int c = p.c;
			for (int i = 0; i < 4; i++) {
				int nr = r;
				int nc = c;
				while(true) {
					nr += dr[i];
					nc += dc[i];
					if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc] == 'O') break;
					if(map[nr][nc] == 'T') {
						return;
					}
				}
			}
		}
		System.out.println("YES");
		System.exit(0);
	}
	
	private static class Point{
		int r, c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
