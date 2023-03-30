package BOJ.BOJ5;

import java.io.*;
import java.util.*;

/*
 * mCn
 */
public class BOJ_1010_다리놓기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[][] B = new int[N+1][M+1];
			for (int i = 0; i <= N; i++) {
				for (int j = 0, end = Math.min(i, M); j <= end; j++) {
					if(j==0 || i==j) B[i][j] = 1;
					else B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
			System.out.println(B[N][M]);
		}
	}
}
