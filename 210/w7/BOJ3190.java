package w7;

import java.util.*;
import java.io.*;


class Main {
	static int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] cmd; 
	static int[][] board;
	static int[][] directions;
	static int N, K, L, dir = 0, startL = 0;
	public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("./inputs/input_BOJ3190.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		directions = new int[N][N];
		
		
		K = Integer.parseInt(br.readLine()); 
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
		}
		
		L = Integer.parseInt(br.readLine());
		cmd = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());

			cmd[i][0] = Integer.parseInt(st.nextToken());
			cmd[i][1] = st.nextToken().equals("D") ? 1 : -1;
		}
		
		board[0][0] = 1;
		directions[0][0] = dir;
		System.out.println(play());
	}
	
	private static int play() {
		int time = 0;
		int hr = 0, hc = 0, tr = 0, tc = 0;
		
		while(true) {
			time++;
			int tmp = -1;
			
			directions[hr][hc] = dir;
			tmp = directions[tr][tc];
			hr += ds[dir][0];
			hc += ds[dir][1];
			
			if (hr < 0 || hr >= N || hc < 0 || hc >= N || board[hr][hc] == 1) break;
			
			if (board[hr][hc] != 2) {
				board[hr][hc] = 1;
				board[tr][tc] = 0;
				
				int currDir = directions[tr][tc];
				tr += ds[currDir][0];
				tc += ds[currDir][1];
			}
			else {
				board[hr][hc] = 1;
			}
			
			changeDir(time);
		}
		
		return time;
	}

	private static void changeDir(int time) {
		for (int i = startL; i < L; i++) {
			if (cmd[i][0] == time) {
				startL = i + 1;
				dir = (dir + 4 + cmd[i][1]) % 4;
				return;
			}
		}
	}

}
