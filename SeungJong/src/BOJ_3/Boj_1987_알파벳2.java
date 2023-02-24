package BOJ_3;

import java.util.*;
import java.io.*;

public class Boj_1987_알파벳2 {

	static int R, C, Ans;
	static char[][] map;
	static boolean[] v = new boolean[26];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		v[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(Ans);
	}
	private static void dfs(int r, int c, int cnt) {
		Ans = Math.max(Ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];			
			if(nr<0 || nc<0 || nr>=R || nc>=C ||v[map[nr][nc]-'A']) continue;
			v[map[nr][nc]-'A'] = true;
			dfs(nr, nc, cnt+1);
			v[map[nr][nc]-'A'] = false;		
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
}
