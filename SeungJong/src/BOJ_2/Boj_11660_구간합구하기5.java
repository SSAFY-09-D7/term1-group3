package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj_11660_구간합구하기5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		StringBuilder sb = new StringBuilder();
		int[][] sum = new int[N][N];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = 0;
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				temp += arr[i][j];
				sum[i][j] = temp;
			}
		}
		for (int i = 0; i < M; i++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			for (int j = x1; j <= x2; j++) {
				if(y2 == y1) {
					ans += arr[j][y2];
				}
				else if(y1==0) ans += sum[j][y2];
				else ans += sum[j][y2] - sum[j][y1==0?0:y1-1];
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

}
