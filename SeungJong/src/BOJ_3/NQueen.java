package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen {
	
	static int N, Ans;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		solve(0); // N*N 일때 종료
		System.out.println(Ans);
	}
	/*
	 * Queen : 1
	 * blank : 0
	 */
	private static void solve(int r) {
		// basis part
		if(r == N) {
			Ans++;
//			print(map);
			return;
		}
		
		// inductive part
		for (int c = 0; c < N; c++) {
			if(check(r, c)) {
				map[r][c] = 1;
				solve(r+1);
				map[r][c] = 0;				
			}
		}
		
	}
	// r, c 위치에 퀸을 놓는 시점에 검사해야 하는 방향은
	// 왼쪽 위 대각선, 위, 오른쪽 위 대각선
	// 퀸이 있으면 false 없으면 true
	
	private static boolean check(int r, int c) {
		for (int i = r-1; i >= 0; i--) {
			if(map[i][c]==1) return false;
		}
		for (int i = r-1, j=c-1; i >=0 && j >= 0; i--, j--) {
			if(map[i][j] == 1) return false;
		}
		for (int i = r-1, j = c+1; i >= 0 && j<N; i--, j++) {
			if(map[i][j] == 1) return false;
		}
		return true;
	}
	
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
