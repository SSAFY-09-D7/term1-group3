package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_17281_야구 {
	static int[][] map;
	static int Score, N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(new int[9], 0, 0);
		System.out.println(Score);
	}
	private static void solve(int[] sel, int k, int flag) {
		if(k == 9) {
			if(sel[3] == 1) {
//				System.out.println(Arrays.toString(sel));
				getScore(sel);
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if((flag & (1<<i)) != 0) continue;
			sel[k] = i+1;
			solve(sel, k+1, flag | (1<<i));
		}
	}
	private static void getScore(int[] sel) {
		int cnt = 0;
		int index = 0;
		for (int i = 0; i < N; i++) {
			int outCnt = 0;			
			int[] base = new int[5];
			L:while(true) {
				int hit = map[i][sel[index]-1];
				switch (hit) {
				case 0:
					outCnt++;
					if(outCnt == 3) {
						index++;
						if(index>=9) index = 0;
						break L;
					}
					break;
				case 1:
				case 2:
				case 3:
					for (int j = 3; j > 0; j--) {
						if(base[j] == 1) {
							if(j+hit >= 4) {
								cnt++;
								base[j] = 0;
							}
							else {
								base[j+hit] = 1;
								base[j] = 0;
							}
						}
					}
					base[hit] = 1;
					break;
				case 4:
					cnt++;
					for (int j = 1; j < 4; j++) {
						if(base[j] == 1) {
							cnt++;
							base[j] = 0;
						}
					}
					break;
				}				
				index++;
				if(index >= 9) index = 0;
//				System.out.println(index);
			}

//			System.out.println(Arrays.toString(base));
		}
		Score = Math.max(Score, cnt);
	}

}
