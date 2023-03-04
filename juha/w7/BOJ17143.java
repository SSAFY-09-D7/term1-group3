package com.study.w7;

import java.io.*;
import java.util.*;

public class BOJ17143 {
	static int R, C, M, sum;
	static int[][] map;
	static HashMap<Integer, Shark> hm;
	static Queue<Integer> queue;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static class Shark{
		int r, c, d, s;

		public Shark(int r, int c, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("study.w7/BOJ17143.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hm = new HashMap<>();
		map = new int[R][C];
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			hm.put(z, new Shark(r-1, c-1, s, d-1));			
			map[r-1][c-1] = z;
		}
		
		sum = 0;
		queue = new LinkedList<>();
		for(int i = 0;i < C;i++) {
			catchShark(i);
			if(hm.size() != 0) {
				moveShark();
			}
		}
		
		System.out.println(sum);
	}

	private static void print() {
		for(int i = 0;i<R;i++) {
			for(int j = 0;j<C;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void catchShark(int c) {
		for(int i = 0;i<R;i++) {
			if(map[i][c] > 0) {
				sum += map[i][c];
				hm.remove(map[i][c]);
				map[i][c] = 0;
				return;
			}
		}
	}
	
	private static void moveShark() {
		for(int i = 0;i<R;i++) {
			Arrays.fill(map[i], 0);
		}
		
		for(Integer i : hm.keySet()) {
			Shark sh = hm.get(i);
			int nr = sh.r;
			int nc = sh.c;
			int speed = sh.s;
			
			while(speed != 0) {
				if(sh.d == 0 || sh.d == 1) {
					if(nr == 0) {
						sh.d = 1;
					}else if(nr == R-1) {
						sh.d = 0;
					}
					nr = nr + dr[sh.d];
					speed--;
					continue;
				}else {
					if(nc == 0) {
						sh.d = 2;
					}else if(nc == C-1) {
						sh.d = 3;	
					}
					nc = nc + dc[sh.d];
					speed--;
				}
				
			}
			
			if(map[nr][nc] == 0) {
				hm.put(i, new Shark(nr, nc, sh.s, sh.d));
				map[nr][nc] = i;
			}else {
				if(map[nr][nc] > i) {
					queue.offer(i);
				}else {
					queue.offer(map[nr][nc]);
					map[nr][nc] = i;
					hm.put(i, new Shark(nr, nc, sh.s, sh.d));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			hm.remove(queue.poll());
		}
	}

}
