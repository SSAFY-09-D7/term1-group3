package w09;

import java.util.*;
import java.io.*;

class Main {
	static int W, H, dustCnt, result;
	static char[][] board;
	static int[][] weights;
	static int[][] ds = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("./inputs/input_BOJ4991.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) break;
			board = new char[H][W];
			result = Integer.MAX_VALUE;
			
			char idx = '0';
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					board[i][j] = str.charAt(j);
					if (board[i][j] == '*')  {
						board[i][j] = idx++;
						q.add(new Point(i, j, board[i][j], 0));
						
					} else if (board[i][j] == 'o') {
						q.add(new Point(i, j, 'o', 0));
					}
				}
			}
			
			dustCnt = idx - '0';
			weights = new int[dustCnt + 1][dustCnt + 1];
			
			
			bfs();
			
            // 갈 수 없으면 예외처리
			for (int i = 0; i < dustCnt; i++) {
				if (weights[dustCnt][i] == 0) {
					result = -1;
					break;
				}
			}
			if (result != -1) perm(new int[dustCnt], new boolean[dustCnt], 0);
			System.out.println(result == 0 ? -1 : result);
		}	

	}
	
	private static void perm(int[] tmp, boolean[] visited, int depth) {
		if (depth == dustCnt) {
			result = Math.min(result, getWeightSum(tmp));
			
		}
		
		for (int i = 0; i < dustCnt; i++) {
			if (!visited[i]) {
				visited[i] = true;
				tmp[depth] = i;
				perm(tmp, visited, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	private static int getWeightSum(int[] tmp) {
		int sum = 0;
		
		int prev = dustCnt;
		for (int i = 0; i < dustCnt; i++) {
			sum += weights[prev][tmp[i]];
			prev = tmp[i];
		}
		
		return sum;
	}
	
	
	private static void bfs() {
		boolean[][][] visited = new boolean[H][W][dustCnt+1]; 
		while(!q.isEmpty()) {
			Point p = q.poll();
			int layer = p.idx == 'o' ? dustCnt : p.idx - '0';
			visited[p.r][p.c][layer] = true;
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + ds[i][0];
				int nc = p.c + ds[i][1];
				
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc] == 'x' || visited[nr][nc][layer]) continue;
				
				visited[nr][nc][layer] = true;
				if (board[nr][nc] != '.' && board[nr][nc] != p.idx) {
					int b = board[nr][nc] == 'o'? dustCnt : board[nr][nc] - '0';
					weights[layer][b] = p.cnt + 1;
					weights[b][layer] = p.cnt + 1;
				}
				
				q.add(new Point(nr, nc, p.idx, p.cnt + 1));
			}
		}
	}
	
	static class Point {
		int r, c, cnt;
		char idx;

		public Point(int r, int c, char idx, int cnt) {
			this.r = r;
			this.c = c;
			this.idx = idx;
			this.cnt = cnt;
		}
	}

}
