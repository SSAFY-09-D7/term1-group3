package com.ssafy.study.w3;
import java.util.*;
import java.lang.*;

public class security {
	static int[][] cw = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int[][] ccw = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c, r;
		c = sc.nextInt();
		r = sc.nextInt();
		
		int[][] rect = new int[r+1][c+1];
		int storeNum = sc.nextInt();
		for(int i = 0;i<storeNum;i++) {
			switch(sc.nextInt()) {
			case 1:
				rect[0][sc.nextInt()] = 1;
				break;
			case 2:
				rect[rect.length-1][sc.nextInt()] = 1;
				break;
			case 3:
				rect[sc.nextInt()][0] = 1;
				break;
			case 4:
				rect[sc.nextInt()][rect[0].length-1] = 1;
				break;
			}
		}

		
		int secR = 0, secC = 0, dir = 0;
		switch(sc.nextInt()) {
		case 1:
			dir = 0;
			secR = 0;
			secC = sc.nextInt();
			break;
		case 2:
			dir = 2;
			secR = rect.length-1;
			secC = sc.nextInt();
			break;
		case 3:
			dir = 3;
			secR = sc.nextInt();
			secC = 0;
			break;
		case 4:
			dir = 1;
			secR = sc.nextInt();
			secC = rect[0].length-1;
			break;
		}
		
		int sum = 0;
		for(int i = 0;i<storeNum;i++) {
			sum += Math.min(cwDis(rect, secR, secC, dir), ccwDis(rect, secR, secC, dir));
		}
		System.out.println(sum);
	}
	
	public static int cwDis(int[][] rect, int r, int c, int dir) {
		int cnt = 0;
		System.out.println(dir);
		int dr = r, dc = c;
		
		while(true) {
			dr = dr + cw[dir%4][0];
			dc =  dc + cw[dir%4][1];
			if(rect[dr][dc] == 1) {
				System.out.println("cw: " + cnt);
				break;
			}
			if(dr+cw[dir%4][0] >= rect.length || dr+cw[dir%4][0] <= 0 || dc+cw[dir%4][1] >= rect[0].length || dc+cw[dir%4][1] <= 0) {
				dir++;
			}
			cnt++;
		}
		
		return cnt;
	}
	
	public static int ccwDis(int[][] rect, int r, int c, int dir) {
		int cnt = 0;
		System.out.println(dir);
		int dr = r, dc = c;
		
		
		while(true) {
			dr = dr + cw[dir%4][0];
			dc =  dc + cw[dir%4][1];
			if(rect[dr][dc] == 1) {
				rect[dr][dc] = 0;
				System.out.println("ccw: " + cnt);
				break;
			}
			if(dr+cw[dir%4][0] >= rect.length || dr+cw[dir%4][0] <= 0 || dc+cw[dir%4][1] >= rect[0].length || dc+cw[dir%4][1] <= 0) {
				dir++;
			}
			cnt++;
		}
		
		return cnt;
	}
}
