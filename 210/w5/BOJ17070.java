package w5;

import java.io.*;
import java.util.*;

class Main {
	static int[][] board;
	static int N;
    public static void main(String[] arg) throws Exception {
		System.setIn(new FileInputStream("./inputs/input_BOJ17070.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken()); 
        	}
        }
        
        dfs();   
    }

	private static void dfs() {		
		Stack<Point> q = new Stack<>();	
		q.push(new Point(0, 1, 0));
		
		int cnt = 0;
		while(!q.isEmpty()) {
				Point p = q.pop();
				if (p.r == N - 1 && p.c == N - 1) {
					cnt++;
					continue;
				}
				
				if (p.prevD == 0) {
					if (p.c < N - 1 && board[p.r][p.c+1] == 0) q.add(new Point(p.r, p.c+1, 0));
					if (p.r < N - 1 && p.c < N - 1 && board[p.r][p.c+1] == 0 && board[p.r+1][p.c] == 0 && board[p.r+1][p.c+1] == 0) q.add(new Point(p.r+1, p.c+1, 2));
				} else if (p.prevD == 1) {
					if (p.r < N - 1 && board[p.r+1][p.c] == 0) q.add(new Point(p.r + 1, p.c, 1));
					if (p.r < N - 1 && p.c < N - 1 && board[p.r][p.c+1] == 0 && board[p.r+1][p.c] == 0 && board[p.r+1][p.c+1] == 0) q.add(new Point(p.r+1, p.c+1, 2));
				} else {
					if (p.c < N - 1 && board[p.r][p.c+1] == 0) q.add(new Point(p.r, p.c+1, 0));
					if (p.r < N - 1 && board[p.r+1][p.c] == 0) q.add(new Point(p.r + 1, p.c, 1));
					if (p.r < N - 1 && p.c < N - 1 && board[p.r][p.c+1] == 0 && board[p.r+1][p.c] == 0 && board[p.r+1][p.c+1] == 0) q.add(new Point(p.r+1, p.c+1, 2));
				}
		}
		
		System.out.println(cnt);
	}
    
    static class Point {
    	int r, c, prevD;

		public Point(int r, int c, int prevD) {
			super();
			this.r = r;
			this.c = c;
			this.prevD = prevD;
		}
    }
}
