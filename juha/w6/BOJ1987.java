package hw_0223;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1987 {
	static int R,C, cnt;
	static char[][] map;
	static boolean[] alphabet;
	static Stack<Point> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hw_0223/BOJ1987.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		alphabet = new boolean[26];
		for(int i = 0;i<R;i++) {
			String s = br.readLine();
			for(int j = 0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		cnt = 1;
		dfs(0,0, 1, new boolean[R][C]);
		System.out.println(cnt);
	}
	static class Point{
		int r,c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void dfs(int r, int c, int pCnt, boolean[][] v) {		
		alphabet[map[r][c] - 'A'] = true;
		
		for(int d = 0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<R && nc>=0 && nc<C && !v[nr][nc]) {
				if(!alphabet[map[nr][nc] - 'A']) {
					v[nr][nc] = true;
					alphabet[map[nr][nc] - 'A'] = true;
					cnt = Math.max(cnt, pCnt+1);
					dfs(nr, nc, pCnt+1, v);
					v[nr][nc] = false;
					alphabet[map[nr][nc] - 'A'] = false;					
				}
			}
		}
		
		
	}

}
