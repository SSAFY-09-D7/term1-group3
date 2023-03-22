package w06;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result = 111;
	static int redR, redC, blueR, blueC, holeR, holeC;
	static char[][] board;
	static int[][] ds = {{0, 1}, {1,0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./inputs/input_BOJ13460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					redR = i;
					redC = j;
					board[i][j] = '.';
				}
				
				if (board[i][j] == 'B') {
					blueR = i;
					blueC = j;
					board[i][j] = '.';
				}
				
				if (board[i][j] == 'O') {
					holeR = i;
					holeC = j;
				}
			}
		}
		
		bfs();
		
		System.out.println(result == 111? -1 : result);
		
	}
	
	private static void bfs() {
		Queue<State> q = new LinkedList<>();
		q.add(new State(redR, redC, blueR, blueC, 0, -1));
		
		while(!q.isEmpty()) {
			State s = q.poll();
			
			if (s.cnt == 10) {
				result = result == 111? -1 : result;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				if ((i + 2) % 4 == s.prevDir) continue;
				int[] redPos, bluePos;
				
				if ((i == 0 && s.redC > s.blueC) || (i == 1 && s.redR > s.blueR) || (i == 2 && s.redC < s.blueC) || (i == 3 && s.redR < s.blueR)) {					
					redPos = move(s.redR, s.redC, s.blueR, s.blueC, i);
					bluePos = move(s.blueR, s.blueC, redPos[0], redPos[1], i);

					
				} else {					
					bluePos = move(s.blueR, s.blueC, s.redR, s.redC, i);
					redPos = move(s.redR, s.redC, bluePos[0], bluePos[1], i);
					
				}
				
				
				
				if (s.redR == redPos[0] && s.redC == redPos[1] && s.blueR == bluePos[0] && s.blueC == bluePos[1]) continue;
				if (bluePos[0] == -1 && bluePos[1] == -1) continue;
				if (redPos[0] == -1 && redPos[1] == -1) { 
					result = Math.min(result, s.cnt + 1);	
					return;
				}
				
				
				q.add(new State(redPos[0], redPos[1], bluePos[0], bluePos[1], s.cnt + 1, i));	
			}
		}
	}
	
	private static int[] move(int myR, int myC, int otherR, int otherC, int dir) {
		int nr = myR;
		int nc = myC;
		
		while (true) {
			if (nr == holeR && nc == holeC) return new int[] {-1, -1};
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != '.' || (nr == otherR && nc == otherC)) {
				return new int[] {nr - ds[dir][0], nc - ds[dir][1]};
			}
			
			nr += ds[dir][0];
			nc += ds[dir][1];
		}
	}
	
	static class State {
		int redR;
		int redC;
		int blueR;
		int blueC;
		int cnt;
		int prevDir;
		
		public State(int redR, int redC, int blueR, int blueC, int cnt, int prevDir) {
			super();
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
			this.cnt = cnt;
			this.prevDir = prevDir;
		}
	}
}
