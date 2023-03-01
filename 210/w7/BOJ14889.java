package w7;

import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[][] board;
	static int minGap = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./inputs/input_BOJ14889.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		combi(new boolean[N], 0, 0);
		
		System.out.println(minGap);
	}
	
	private static void combi(boolean[] sel, int depth, int start) {
		if (depth == N/2) {
			minGap = Math.min(minGap, getGap(sel));
		}
		
		for (int i = start; i < N; i++) {
			sel[i] = true;
			combi(sel, depth+1, i+1);
			sel[i] = false;
		}
	}

	private static int getGap(boolean[] sel) {
		int trueSum = 0;
		int falseSum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sel[i] && sel[j]) {
					trueSum += board[i][j];
					
				} else if (!sel[i] && !sel[j]) {
					falseSum += board[i][j];
				}
			}
		}
		
		return Math.abs(trueSum - falseSum);
	}
}
