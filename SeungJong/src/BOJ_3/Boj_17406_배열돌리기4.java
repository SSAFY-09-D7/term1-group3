package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17406_배열돌리기4 {

	static int N, M, K;
	static int[][] arr;
	static int[][] rot;
	static int[][] temp;
	static int Ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		temp = new int[N][M]; // 원복배열
		rot = new int[K][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int t = Integer.parseInt(st.nextToken());
				arr[i][j] = t;
				temp[i][j] = t;
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rot[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		permutation(new int[K][3], 0, 0);
		System.out.println(Ans);
	}
	private static void permutation(int[][] sel, int k, int flag) {
		if(K == k) {
			recurve();
			for (int i = 0; i < K; i++) {
				rotation(sel[i][0], sel[i][1], sel[i][2]);
			}
			calcMin();
			return;
		}
		for (int i = 0; i < K; i++) {
			if((flag & (1<<i)) != 0) continue;
			sel[k][0] = rot[i][0];
			sel[k][1] = rot[i][1];
			sel[k][2] = rot[i][2];
			permutation(sel, k+1, flag | (1<<i));
		}
	}
	private static void recurve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}
	private static void calcMin() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += temp[i][j];
			}
			Ans = Math.min(Ans, sum);
		}
	}
	private static void rotation(int r, int c, int s) {
		int val;
		r--;
		c--;
		for (int i = s; i > 0; i--) {
			int dir = 0;
			int row = r - i;
			int col = c - i;
			val = temp[row][col];
			while(dir!=4) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				temp[row][col] = temp[nr][nc];
				row = nr;
				col = nc;
				if(dir == 0 && row == r+i) dir++;
				else if(dir == 1 && col == c+i) dir++;
				else if(dir == 2 && row == r-i) dir++;
				else if(dir == 3 && col == c-i) dir++;
			}
			temp[r-i][c-i+1] = val;		
		}
	}
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
}
