package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M, R, square;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		square = Math.min(N, M) / 2;
		int[][] arr = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			rotateArr(arr, N, M, square);						
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
//				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}
	}

	private static void rotateArr(int[][] arr, int N, int M, int s) {
		for (int i = 0; i < s; i++) {
			int squareI = N-1-i;
			int squareJ = M-1-i;
			int temp = arr[i][i];
			for (int j = i; j < squareJ; j++) {
				arr[i][j] = arr[i][j+1];
			}
			for (int j = i; j < squareI; j++) {
				arr[j][squareJ] = arr[j+1][squareJ];
			}
			for (int j = squareJ; j > i; j--) {
				arr[squareI][j] = arr[squareI][j-1];
			}
			for (int j = squareI; j > i; j--) {
				arr[j][i] = arr[j-1][i];
			}
			arr[i+1][i] = temp;
		}
	}
}