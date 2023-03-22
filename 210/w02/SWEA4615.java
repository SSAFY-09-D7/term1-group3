package w02;

import java.util.*;
import java.io.FileInputStream;

class Solution
{
	private static int[][] ds = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("./inputs/input_SWEA4615.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] board = new int[n][n];
			init(board, n);
			
			for (int i = 0; i < m; i++) {
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				int color = sc.nextInt();
				
				board[r][c] = color;
				
				searchNear(board, n, r, c, color);
				print(board);				
			}
			
			int[] cnts = count(board, n);
			System.out.println("#"+ test_case + " " + cnts[1] + " " + cnts[2] );
			
		}
	}
	
	private static void init(int[][] board, int n) {
		board[n/2 - 1][n/2 - 1] = board[n/2][n/2] = 2;
		board[n/2 - 1][n/2] = board[n/2][n/2 - 1] = 1;	
	}
	
	private static int searchNear(int[][] board, int n, int r, int c, int color) {
		int otherColor = color == 1? 2 : 1;
		int result = 1;
		
		for (int i = 0; i < 8; i++) {
			int currR = r + ds[i][0];
			int currC = c + ds[i][1];
			
			if (currR < 0 || currR >= n || currC < 0 || currC >= n) continue;
			
			if (board[currR][currC] == otherColor) {
				checkAndChange(board, n, r, c, i, color);
			}
		}
		
		return result;
	}
	
	// 쭉 otherColor이다가 color이 되어야 한다
	private static void checkAndChange(int[][] board, int n, int r, int c, int d, int color) {
		int otherColor = color == 1? 2 : 1;
		int currR = r;
		int currC = c;
		List<Integer> rs = new ArrayList<>();
		List<Integer> cs = new ArrayList<>();
		boolean isPossible = false;
		
		for (int i = 0; i < n; i++) {
			currR += ds[d][0];
			currC += ds[d][1];
			
			if (currR < 0 || currR >= n || currC < 0 || currC >= n || board[currR][currC] == 0) break;
			
			if (board[currR][currC] == color) {
				isPossible = true;
				break;
			} else if (board[currR][currC] == otherColor) {
				rs.add(currR);
				cs.add(currC);
			}
		}
		
		if (isPossible) {
			fill(board, rs, cs, color);
		} 
	}
	
	private static void fill(int[][] board, List<Integer> rs, List<Integer> cs, int color) {
		for (int i = 0; i < rs.size(); i++) {
			board[rs.get(i)][cs.get(i)] = color;
		}
	}
	
	private static int[] count(int[][] board, int n) {
		int[] res = new int[3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) res[1]++;
				else if (board[i][j] == 2) res[2]++;
			}
		}
		
		return res;
	}
	
	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println();
	}
}