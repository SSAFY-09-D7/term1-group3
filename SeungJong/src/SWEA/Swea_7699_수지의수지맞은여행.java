package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_7699_수지의수지맞은여행 {

	static int R, C;
	static String[][] map;
	static String check="";
	static int Ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea7699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			check="";
			Ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new String[R][C];
			for (int i = 0; i < R; i++) {
				String temp = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = temp.substring(j,j+1);
				}
			}
			if(R == 1 && C == 1) Ans = 1;
			else dfs();
			System.out.println("#"+tc+" "+Ans);
		}
	}
	
	
	private static void dfs() {
		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point(0, 0, map[0][0]));
		boolean[][] v = new boolean[R][C];
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			v[p.r][p.c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || p.str.contains(map[nr][nc])) continue;
				v[nr][nc] = true;
				stack.push(new Point(nr, nc, p.str+map[nr][nc]));
				Ans = Math.max(Ans,  (p.str+map[nr][nc]).length());
			}
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static public class Point{
		int r, c;
		String str;

		public Point(int r, int c, String str) {
			super();
			this.r = r;
			this.c = c;
			this.str = str;
		}
	}

}
