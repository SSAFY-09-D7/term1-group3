package com.w4;
import java.util.*;

public class BOJ2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] bingo = new int[5][5];
		
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		for(int i = 1;i<=25;i++) {
			deleteNum(sc.nextInt(), bingo);			
			if(i>=5) {
				cnt = checkBingo(bingo);
				if(cnt>=3) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	private static int checkBingo(int[][] bingo) {
		int check = 0;
		for(int i = 0;i<bingo.length;i++) {
			if(bingo[i][0] == 0) {
				for(int j = 1;j<bingo.length;j++) {
					if(bingo[i][j]!=0) break;
					if(j == bingo.length-1) {
						check++;
					}
				}
			}
			if(bingo[0][i]==0) {
				if(i==bingo.length-1) {
					for(int j = 1;j<bingo.length;j++) {
						if(bingo[j][i - j] != 0) break;
						if(j == bingo.length-1) {
							check++;
						}
					}
				}else if(i == 0) {
					for(int j = 1;j<bingo.length;j++) {
						if(bingo[j][j] != 0) break;
						if(j == bingo.length-1) {
							check++;
						}
					}	
				}
				for(int j = 1;j<bingo.length;j++) {
					if(bingo[j][i]!=0) break;
					if(j == bingo.length-1) {
						check++;
					}
				}
			}
		}
		return check;
	}

	private static void deleteNum(int num, int[][] bingo) {
		for(int i = 0;i<bingo.length;i++) {
			for(int j = 0;j<bingo[i].length;j++) {
				if(bingo[i][j] == num) {
					bingo[i][j] = 0;
					return;
				}
			}
		}
	}

}
