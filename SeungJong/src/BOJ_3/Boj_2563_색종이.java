package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2563_색종이 {

	static int[][] map = new int[101][101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int R = L+10;
			int U = D+10;			
			for (int j = L; j < R; j++) {
				for (int k = D; k < U; k++) {
					map[j][k] = 1;
				}
			}	
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 1) count++;
			}
		}
		System.out.println(count);
	}

}
