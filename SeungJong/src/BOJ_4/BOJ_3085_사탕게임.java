package BOJ.BOJ4;

/*
 * 2차원 배열을 탐색하면서 하나하나 개수를 세는 메소드
 * 메소드는 원래 상태일 때 개수를 세는부분과
 * 위치를 바꿨을 때 (기존 -> 오른쪽), (기존 -> 아래) 세는 부분으로 구성
 * 세는 부분은 기존 위치와 바뀌는 위치 두 부분에서 위 아래 세는 부분과 왼쪽 오른쪽 세는 부분으로 나뉜다.
 */

import java.io.*;
import java.util.*;

public class BOJ_3085_사탕게임 {
	static int N, Ans;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solve(i, j);
			}
		}
		System.out.println(Ans);
	}
	
	private static void solve(int r, int c) {
		// 원상태 카운팅
		count(r, c);
		for (int i = 0; i < 2; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			char temp = map[r][c];
			map[r][c] = map[nr][nc];
			map[nr][nc] = temp;
			count(r,c);
			count(nr, nc);
			map[nr][nc] = map[r][c];
			map[r][c] = temp;
		}
	}

	private static void count(int r, int c) {
		// 상하 방향을 세는부분
		int cnt = 1;
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			while(true) {
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
				if(map[nr][nc] == map[nr-dr[i]][nc-dc[i]]) {
					cnt++;
					nr += dr[i];
					nc += dc[i];
				}
				else break;
			}
		}
		Ans = Math.max(Ans, cnt);
		cnt = 1;
		// 좌우 방향을 세는 부분
		for (int i = 2; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			while(true) {
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
				if(map[nr][nc] == map[nr-dr[i]][nc-dc[i]]) {
					cnt++;
					nr += dr[i];
					nc += dc[i];
				}
				else break;
			}
		}
		Ans = Math.max(Ans, cnt);
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] delta = {{1, 0}, {0, 1}};
}
