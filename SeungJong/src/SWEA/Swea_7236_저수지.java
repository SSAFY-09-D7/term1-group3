package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7236_저수지 {

	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			char[][] area = new char[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = st.nextToken().charAt(0);
				}
			}
			count = findMax(area, N);
			System.out.println("#"+tc+" "+count);
		}
	}
	private static int findMax(char[][] area, int N) {
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = countW(area, i, j, N);
				maxCount = Math.max(count,  maxCount);
			}
		}
		return maxCount;
	}
	private static int countW(char[][] area, int row, int col, int N) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			int nx = row+dx[i];
			int ny = col+dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(area[nx][ny] == 'W') count++;
		}
		return count;
	}

}
