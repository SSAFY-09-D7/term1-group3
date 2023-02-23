package com.w5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ1051 {
	static int N, M;
	static int[][] rect;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ1051.txt"));
		//Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		rect = new int[N][M];
		for(int i = 0;i<N;i++) {
			String s = sc.next();
			for(int j = 0;j<M;j++) {
				rect[i][j] = s.charAt(j) - '0';
			}
		}
		
		findSquare();
		
	}

	private static void findSquare() {
		int len = Math.min(N, M);
		L: while(true) {
			if(len ==1) {
				System.out.println(1);
				break;
			}
			for(int i = 0;i<i+len;i++) {
				if(i+len>N) break;
				for(int j = 0;j<j+len;j++) {
					if(j+len>M) break;
					int temp = rect[i][j];
					if(temp == rect[i+len-1][j] && temp == rect[i+len-1][j+len-1] && temp == rect[i][j+len-1]) {
						System.out.println(len*len);
						break L;
					}
				}
			}
			len--;
		}
	}

}
