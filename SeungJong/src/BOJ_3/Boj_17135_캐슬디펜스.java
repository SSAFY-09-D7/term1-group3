package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_17135_캐슬디펜스 {

	static int N, M, D, Ans;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./input/input_boj17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(new int[3], 0, 0);
		System.out.println(Ans);
	}
	private static void solve(int[] sel, int idx, int k) {
		if(k == sel.length) {
			int num = countAttack(sel);
			Ans = Math.max(Ans, num);
			return;
		}
		for (int i = idx; i < M; i++) {
			sel[k] = i;
			solve(sel, i+1, k+1);
		}
	}
	private static int countAttack(int[] sel) {
		int count = 0;
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			count += check(temp, sel);
			for (int j = N-1; j > 0; j--) { 
				for (int k = 0; k < M; k++) {
					temp[j][k] = temp[j-1][k];
				}
			}		
			for (int j = 0; j < M; j++) {
				temp[0][j] = 0;
			}
		}
		return count;
	}
	private static int check(int[][] arr, int[] sel) { // 궁수 3명이 같은걸 쏘지 않고 다 쏘던가 
		int count = 0;								   // 거리가 멀어서 못 쏘던가
		/*
		 * 고쳐야 할 것: 가장 가까운 적을 쏴야함
		 * 가장 가까운 적이 여럿이라면 제일 왼쪽에 있는 적을 쏨
		 * 동시에 같은 적을 쏠 수 있음
		 * 
		 * 해결 방향: 찾자마자 지우지 말고 각 궁수가 죽이는 적의 좌표를 얻어낸다
		 * 해당 좌표가 1이면 0으로 만들고 카운트 증가 0이면 pass
		 */
		Point[] location = new Point[3];

		for (int k = 0; k < 3; k++) {
			L:for (int d = 1; d <= D; d++) {
				for (int j = 0; j < M; j++) {
					for (int i = N-1; i >= 0; i--) {
						if(arr[i][j] == 1) {
							int diff = Math.abs(i-N) + Math.abs(j-sel[k]);	
							if(diff<=d) {
								location[k] = new Point(i, j);
								break L;
							}
						}
					}
				}
			}			
		}

		for (int i = 0; i < 3; i++) {
			if(location[i] != null && arr[location[i].r][location[i].c] == 1) {
				count++;
				arr[location[i].r][location[i].c] = 0;
			}
		}
		return count;
	}
	private static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

}
