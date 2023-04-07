package w11;

import java.io.*;
import java.util.*;

public class BOJ12100 {
	static int N, maxBlock;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ12100.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxBlock = 0;
		make2048(0);
		
		System.out.println(maxBlock);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void make2048(int cnt) {
		if(cnt == 5) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					maxBlock = Math.max(maxBlock, board[i][j]);
				}
			}
			
			return;
		}
		
		int[][] boardCopy = new int[N][N];
		clone(boardCopy, board);
		
		for(int d = 0; d<4; d++) {
			push(d);
			make2048(cnt+1);
			clone(board, boardCopy);
		}
	}
	
	private static void print() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void push(int d) {
		Queue<Integer> queue = new LinkedList<>();
		switch(d) {
		case 0:
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[j][i] == 0) continue;
					queue.offer(board[j][i]);
				}
				for(int j = 0; j<N; j++) {
					board[j][i] = 0;
				}
				int idx = 0;
				while(!queue.isEmpty()) {
					board[idx][i] = queue.poll();
					idx++;
				}
				
				for(int j = N-1; j>0; j--) {
					if(board[j][i] == 0) continue;
					if(board[j][i] == board[j+dr[d]][i+dc[d]]) {
						board[j][i] += board[j][i];
						board[j+dr[d]][i+dc[d]] = 0;
					}
					queue.offer(board[j][i]);
				}
				if(board[0][i] != 0) queue.offer(board[0][i]);				
				
				idx = N-1;
				for(int j = 0; j<N; j++) {
					board[j][i] = 0;
				}
				while(!queue.isEmpty()) {
					board[idx][i] = queue.poll();
					idx--;
				}
			}
			break;
		case 1:
			for(int i = 0; i<N; i++) {				
				for(int j = 0; j<N; j++) {
					if(board[j][i] == 0) continue;
					queue.offer(board[j][i]);
				}
				for(int j = 0; j<N; j++) {
					board[j][i] = 0;
				}
				int idx = 0;
				while(!queue.isEmpty()) {
					board[idx][i] = queue.poll();
					idx++;
				}
				
				for(int j = 0; j<N-1; j++) {
					if(board[j][i] == 0) continue;
					if(board[j][i] == board[j+dr[d]][i+dc[d]]) {
						board[j][i] += board[j][i];
						board[j+dr[d]][i+dc[d]] = 0;
					}
					
					queue.offer(board[j][i]);
				}
				if(board[N-1][i] != 0) queue.offer(board[N-1][i]);
				
				idx = 0;
				for(int j = 0; j<N; j++) {
					board[j][i] = 0;
				}
				
				while(!queue.isEmpty()) {
					board[idx][i] = queue.poll();
					idx++;
				}
			}
			break;
		case 2:
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[i][j] == 0) continue;
					queue.offer(board[i][j]);
				}
				for(int j = 0; j<N; j++) {
					board[i][j] = 0;
				}
				int idx = 0;
				while(!queue.isEmpty()) {
					board[i][idx] = queue.poll();
					idx++;
				}
				
				
				for(int j = N-1; j>0; j--) {
					if(board[i][j] == 0) continue;
					if(board[i][j] == board[i+dr[d]][j+dc[d]]) {
						board[i][j] += board[i][j];
						board[i+dr[d]][j+dc[d]] = 0;
					}
					queue.offer(board[i][j]);
				}
				if(board[i][0] != 0) queue.offer(board[i][0]);
				
				idx = N-1;
				for(int j = 0; j<N; j++) {
					board[i][j] = 0;
				}
				while(!queue.isEmpty()) {
					board[i][idx] = queue.poll();
					idx--;
				}
			}
			break;
		case 3:
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[i][j] == 0) continue;
					queue.offer(board[i][j]);
				}
				for(int j = 0; j<N; j++) {
					board[i][j] = 0;
				}
				int idx = 0;
				while(!queue.isEmpty()) {
					board[i][idx] = queue.poll();
					idx++;
				}
				
				for(int j = 0; j<N-1; j++) {
					if(board[i][j] == 0) continue;
					if(board[i][j] == board[i+dr[d]][j+dc[d]]) {
						board[i][j] += board[i][j];
						board[i+dr[d]][j+dc[d]] = 0;
					}
					queue.offer(board[i][j]);
				}
				if(board[i][N-1] != 0) queue.offer(board[i][N-1]);
				
				idx = 0;
				for(int j = 0; j<N; j++) {
					board[i][j] = 0;
				}
				while(!queue.isEmpty()) {
					board[i][idx] = queue.poll();
					idx++;
				}
			}
			break;
		}
		
		
	}
	
	private static void clone(int[][] boardCopy, int[][] boardMain) {
		for(int i = 0; i<N; i++) {
			boardCopy[i] = boardMain[i].clone();
		}
		
	}

}
