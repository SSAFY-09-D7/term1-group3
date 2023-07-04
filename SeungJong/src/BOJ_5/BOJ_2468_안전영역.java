package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_2468_안전영역 {

	static int N;
	static int Ans = 1;
	static int maxHeight = 0;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		for (int height = 1; height < maxHeight; height++) {
			v = new boolean[N][N];
			int area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > height && !v[i][j]) {
						dfs(i, j, height);
						area++;
					}
				}
			}
			Ans = Integer.max(Ans, area);
		}
		System.out.println(Ans);
	}

	private static void dfs(int r, int c, int height) {
		v[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr<0 || nc<0 || nr>= N || nc>= N || v[nr][nc]) continue;

			if (map[nr][nc] > height) dfs(nr, nc, height);

		}
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
