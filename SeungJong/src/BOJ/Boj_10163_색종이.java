package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10163_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] area = new int[1001][1001];
		int[] num = new int[4];
		int[] count = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			fillArea(area, num, i+1);
		}
		countArea(area, count);
	}


	private static void fillArea(int[][] area, int[] num, int count) {
		for (int i = num[0]; i < num[2] + num[0]; i++) {
			for (int j = num[1]; j < num[3] + num[1]; j++) {
				area[i][j] = count;
			}
		}
	}
	private static void countArea(int[][] area, int[] count) {
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				for (int k = 1; k < count.length+1; k++) {
					if(area[i][j] == k) {
						count[k-1] ++;
						break;
					}
				}
			}
		}
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}