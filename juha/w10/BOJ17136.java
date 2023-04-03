package w10;

import java.io.*;
import java.util.*;

public class BOJ17136 {
	static int[] paper = {0,5,5,5,5,5};
	static int cnt;
	static int[][] map;
	static int minCnt;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w10/BOJ17136.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		cnt = 0;
		for(int i = 0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cnt++;
			}
		}
		
		if(cnt != 0) {
			minCnt = Integer.MAX_VALUE;
			attachPaper(0);
			
			if(minCnt == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(minCnt);
		}else System.out.println(0);
		
	}
	
	private static void attachPaper(int count) {
		if(count > minCnt) return;
		int r = -1, c = -1;
		L: for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(map[i][j] == 1) {
					r = i;
					c = j;
					break L;
				}
			}
		}
		
		if(r == -1 && c == -1) {
			minCnt = Math.min(minCnt, count);
			return;
		}
		
		int K = findMax(r, c);
		
		for(int k = K; k>=1; k--) {
			if(paper[k] > 0) {
				paper[k]--;
				changePaper(r, c, k, 0);
				attachPaper(count+1);
				changePaper(r, c, k, 1);
				paper[k]++;
			}
		}
	}
	

	private static int findMax(int r, int c) {
		
		for(int k = 5; k>=1; k--) {
			boolean check = true;
			if(r+k<=10 && c+k<=10) {
				L: for(int i = r; i<r+k; i++) {
					for(int j = c; j<c+k; j++) {
						if(map[i][j] != 1) {
							check = false;
							break L;
						}
					}
				}
				if(check) {
					return k;
				}
			}			
		}
		
		return 1;
	}

	private static void print() {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void changePaper(int r, int c, int k, int color) {
		for(int i = r; i<r+k; i++) {
			for(int j = c; j<c+k; j++) {
				map[i][j] = color;
			}
		}		
	}

}
