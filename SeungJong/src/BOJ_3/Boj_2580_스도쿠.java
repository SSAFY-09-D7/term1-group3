package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2580_스도쿠 {

	static int[][] map = new int[9][9];
	static ArrayList<Integer> num = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			num.add(i+1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		print();

	}
	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void dfs(int r, int c) {
		if(map[r][c] == 0) {
			ArrayList<Integer> rowVal = isRowAvailable(r, c);
			ArrayList<Integer> colVal = isColAvailable(r, c);
			ArrayList<Integer> squareVal = isSquareAvailable(r, c);
//			System.out.println(rowVal);
//			System.out.println(colVal);
//			System.out.println(squareVal);
			if(rowVal.size()==1) map[r][c] = rowVal.get(0);
			else if(colVal.size()==1) map[r][c] = colVal.get(0);
			else if(squareVal.size()==1) map[r][c] = squareVal.get(0);
		}
		if(r+1 < 9) dfs(r+1, c);
		if(c+1 < 9) dfs(r, c+1);
	}
	private static ArrayList<Integer> isRowAvailable(int r, int c) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			row.add(i+1);
		}
		int index = 0;
		for (int i = 0; i < 9; i++) {
			if(map[r][i] != 0 && row.contains(map[r][i])) {
				index = row.indexOf(map[r][i]);
				row.remove(index);
			}
		}
//		System.out.println(row);
		return row;
	}
	private static ArrayList<Integer> isColAvailable(int r, int c) {
		ArrayList<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			col.add(i+1);
		}
		int index = 0;
		for (int i = 0; i < 9; i++) {
			if(map[i][c] != 0 && col.contains(map[i][c])) {
				index = col.indexOf(map[i][c]);
				col.remove(index);
			}
		}
//		System.out.println(col);
		return col;
	}
	private static ArrayList<Integer> isSquareAvailable(int r, int c) {
		int row = r/3 * 3;
		int col = r/3 * 3;
		ArrayList<Integer> square = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			square.add(i+1);
		}
		int index = 0;
		for (int i = row; i < row+3; i++) {
			for (int j = col; j < col+3; j++) {
				if(map[i][j] != 0 && square.contains(map[i][j])) {
					index = square.indexOf(map[i][j]);
					square.remove(index);
				}
			}
		}
//		System.out.println(square);
		return square;
	}

}
