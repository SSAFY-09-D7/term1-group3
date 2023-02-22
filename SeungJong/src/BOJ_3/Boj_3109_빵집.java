package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3109_빵집 {

	static int R, C, Ans;
	static char[][] map;
	static int[] dr = {-1, 0, 1}; 
	static int[] dc = {1, 1, 1};
	static boolean flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for (int r = 0; r < R; r++) {
			flag = false;
			solve(r, 0);
			if(flag) Ans++;
		}
		System.out.println(Ans);
		
	}
	private static void solve(int r, int c) {
		if(flag) return; // 속도향상
		
		// basis part
		if(c == C-1) {
			flag = true;
			return;
		}
		
		// inductive part
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr>= R || nc >= C) continue;
			if(map[nr][nc] == '.' && !flag) {
				map[nr][nc] = '!';
				solve(nr, nc);
			}
		}
		
	}

}
