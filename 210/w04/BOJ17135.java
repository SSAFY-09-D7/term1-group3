package w4;package w04;
import java.io.*;
import java.util.*;

class Main
{
	static int n, m, d, maxT, result;
	static int[][] board;
	public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ17135.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	result = -1;
    	maxT = -1;	// 최상단 적 위치
    	board = new int[n][m];
    	
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < m; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    			if (board[i][j] == 1 && maxT == -1) {
    				maxT = n - i;
    			}
    		}
    	} 
    	
    	result = 0;
    	recursive(new int[3], 0, 0);
    	
    	System.out.println(result);
	}
	
	private static void recursive(int[] sel, int idx, int k) {
		if (k == 3) {
			result = Math.max(result, playGame(sel));
			return;
		}
		
		for (int i = idx; i < m; i++) {
			sel[k] = i;
			recursive(sel, i+1, k+1);
		}
	}
	
	private static int playGame(int[] peopleIdxs) {
		int[][] currBoard = getNewBoard();
		int[][] targets = new int[3][2];
		int cnt = 0;
		
		for (int i = 0; i < maxT; i++) {
			for (int j = 0; j < 3; j++) {
				targets[j] = findTarget(currBoard, n-i, peopleIdxs[j]);
			}
			cnt += killTarget(currBoard, targets);
		}
		return cnt;
	}
	
	private static int[] findTarget(int[][] board, int t, int idx) {
		int[] target = { -1, -1 };
		
		if (board[t-1][idx] == 1) {
			target[0] = t-1;
			target[1] = idx;
			return target;
		}
		
		for (int i = 0; i <= d - 1; i++) {
			for (int j = -1 * i; j <= d ; j++) {
				int r = t - 1 - (i - Math.abs(j));
				int c = idx + j;
				
				if (r < 0 || c < 0 || r >= t || c >= m ) continue;
			
				if (board[r][c] == 1) {
					target[0] = r;
					target[1] = c;
					return target;
				}
			}
		}
		
		return target;
	}
	
	private static int killTarget(int[][] board, int[][] targets) {
		int killed = 0;
		
		for (int i = 0; i < 3; i++) {
			int r = targets[i][0];
			int c = targets[i][1];
			
			if (r == -1 || c == -1) continue;
			if (board[r][c] == 1) {
				board[r][c] = 0;
				killed++;
			}
		}
		return killed;
	}
	
	private static int[][] getNewBoard() {
		int[][] result = new int [n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(board[i], 0, result[i], 0, m);
		}
		return result;
	}
}
