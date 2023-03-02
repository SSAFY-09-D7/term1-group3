package com.w7;

import java.io.*;
import java.util.*;

public class BOJ14500 {
	static int N, M, max;
	static int[][] paper;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("com.w7/BOJ14500.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v = new boolean[N][M];
		max = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				dfs(i, j, 0, 0);
				if(j<=M-3) {
					findC(i, j, paper[i][j],0);
				}
				if(i<=N-3) {
					findR(i, j, paper[i][j],0);
				}
			}
		}
		System.out.println(max);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void dfs(int r, int c, int sum, int cnt) {
		if(cnt == 3) {
			max = Math.max(max, sum + paper[r][c]);
			return;
		}
		v[r][c] = true;
		for(int d = 0;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >=0 && nr<N && nc>=0 && nc<M && !v[nr][nc]) {
				dfs(nr, nc, sum + paper[r][c], cnt+1);
			}
		}
		v[r][c] = false;		
	}
	
	private static void findR(int r, int c, int sum, int cnt) {
		if(cnt == 2) {
			int nr = r -1;
			int nc = c -1;
			if(nr >=0 && nr<N && nc>=0 && nc<M ) {
				max = Math.max(max, sum + paper[nr][nc]);
			}
			
			nr = r -1;
			nc = c + 1;
			if(nr >=0 && nr<N && nc>=0 && nc<M ) {
				max = Math.max(max, sum + paper[nr][nc]);
			}
			return;
		}
		
		v[r][c] = true;

		int nr = r + 1;
		int nc = c;
		if(nr >=0 && nr<N && nc>=0 && nc<M && !v[nr][nc]) {
			findR(nr, nc, sum + paper[nr][nc], cnt+1);
		}
		
		v[r][c] = false;
	}
	
	private static void findC(int r, int c, int sum, int cnt) {
		if(cnt == 2) {
			int nr = r -1;
			int nc = c -1;
			if(nr >=0 && nr<N && nc>=0 && nc<M ) {
				max = Math.max(max, sum + paper[nr][nc]);
			}
			
			nr = r + 1;
			nc = c - 1;
			if(nr >=0 && nr<N && nc>=0 && nc<M ) {
				max = Math.max(max, sum + paper[nr][nc]);
			}
			return;
		}
		
		v[r][c] = true;

		int nr = r;
		int nc = c + 1;
		if(nr >=0 && nr<N && nc>=0 && nc<M && !v[nr][nc]) {
			findC(nr, nc, sum + paper[nr][nc], cnt+1);
		}
		
		v[r][c] = false;
	}

}
