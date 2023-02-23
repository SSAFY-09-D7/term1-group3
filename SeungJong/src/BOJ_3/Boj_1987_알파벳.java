package BOJ_3;

import java.util.*;
import java.io.*;

public class Boj_1987_알파벳 {

	static int R, C, Ans;
	static String[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.substring(j,j+1);
			}
		}
		dfs(0, 0, 1, map[0][0]);
		System.out.println(Ans);
	}
	private static void dfs(int r, int c, int cnt, String str) {
		Ans = Math.max(Ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];			
			if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
			if(!str.contains(map[nr][nc])) {
				dfs(nr, nc, cnt+1, str+map[nr][nc]);
			}
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
}
