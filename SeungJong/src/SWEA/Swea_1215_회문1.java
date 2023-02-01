package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea_1215_회문1 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input/input_swea1215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String[] splitter = br.readLine().split("");
				for (int j = 0; j < 8; j++) {
					arr[i][j] = splitter[j].charAt(0);
				}
			}
			
			count += countPalindrome(arr, N);
			bw.write("#"+tc+" "+count+"\n");
			bw.flush();
			
		}
	}

	private static int countPalindrome(char[][] arr, int n) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				count += isPalindrome(arr, n, i, j);
			}
		}
		return count;
	}

	private static int isPalindrome(char[][] arr, int n, int row, int col) {
		String strRow = "";
		String strCol = "";
		int count = 0;
		boolean isBreak = false;
		for (int i = row; i < row+n; i++) {
			if(i >= 8) {
				isBreak = true;
				break;
			}
			strRow += arr[i][col];
		}
		if(!isBreak) {
			StringBuffer sbRow = new StringBuffer(strRow);
			if ( sbRow.reverse().toString().equals(strRow)) {
				count ++;
			}
			
		}
		isBreak = false;
		for (int i = col; i < col+n; i++) {
			if( i >= 8) {
				isBreak = true;
				break;
			}
			strCol += arr[row][i];
		}
		if(!isBreak) {
			StringBuffer sbCol = new StringBuffer(strCol);
			if ( sbCol.reverse().toString().equals(strCol)) {
				count ++;
			}			
		}
		
		return count;
	}
}
