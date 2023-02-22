package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.substring(j,j+1));
			}
		}
		cut(0, 0, N);
		System.out.println(sb);
	}
	private static void cut(int r, int c, int size) {
		int sum = 0;
		int rEnd = r+size;
		int cEnd = c+size;
		for (int i = r; i < rEnd; i++) {
			for (int j = c; j < cEnd; j++) {
				sum += map[i][j];
			}
		}
		if(sum == size * size) {
			sb.append("1");
		} else if(sum == 0) {
			sb.append("0");
		} else {
			sb.append("(");
			int half = size/2;
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			sb.append(")");
		}
	}
	

}
