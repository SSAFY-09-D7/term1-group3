package com.study.w7;

import java.io.*;
import java.util.*;

public class SWEA1767 {
	static int N, maxCore, outlineCore, line;
	static int[][] map;
	static List<Point> coreList;
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("study.w7/SWEA1767.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			outlineCore = 0;
			coreList = new ArrayList<Point>();
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i == 0 || j == 0 || i == N-1 || j == N-1) && map[i][j] == 1) {
						map[i][j] = 3;
						outlineCore++;
					}
					
					if(map[i][j] == 1) {
						coreList.add(new Point(i, j));
					}
				}
			}
			
			line = Integer.MAX_VALUE;
			maxCore = 0;
			findLine(0, 0, 0);
			System.out.println("#" + test_case + " " + line);
		}
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void findLine(int idx, int cnt, int voltLine) {
		if(idx == coreList.size()) {
			int temp = maxCore;
			maxCore = Math.max(maxCore, cnt);
			
			//System.out.println(maxCore);
			if(temp != maxCore) line = Integer.MAX_VALUE;
			if(maxCore == cnt) line = Math.min(line, voltLine);
			
			return;
		}
		if(cnt + coreList.size() - idx < maxCore) {
			return;
		}
		Point p = coreList.get(idx);
		boolean check = false;
		for(int d = 0; d<4; d++) {
			int i = 1;
			while(true) {
				int nr = p.r + dr[d]*i;
				int nc = p.c + dc[d]*i;
				
				if(nr >= 0 && nr < N && nc>=0 && nc<N && map[nr][nc] == 0) {
					if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1){
						check = true;
						int val = Math.abs(nr - p.r) + Math.abs(nc - p.c);
						putLine(p.r, p.c, d, 2);
						findLine(idx+1, cnt+1, voltLine + val);
						putLine(p.r, p.c, d, 0);
					}
					i++;
				}else {
					break;
				}
			}
		}
		findLine(idx + 1, cnt, voltLine);
		if(!check) {
			findLine(idx+1, cnt, voltLine);
		}
	}
	private static void print() {
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void putLine(int r, int c, int d, int fillNum) {
		int idx = 1;
		while(true) {
			int nr = r + dr[d]*idx;
			int nc = c + dc[d]*idx;
			
			if(nr >= 0 && nr < N && nc>=0 && nc<N) {
				map[nr][nc] = fillNum;
				idx++;
			}else return;
		}
	}

}
