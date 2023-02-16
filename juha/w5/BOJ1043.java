package com.study.w5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1043 {
	static String trueStr;
	static List<Integer> list;
	static boolean[] v;
	static int cnt;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ1043.txt"));
		//Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int pNum = sc.nextInt();
		int[][] pAtt = new int[m][];
		if(pNum >0) {
			list = new ArrayList<>();
			for(int i = 0;i<pNum;i++) {
				list.add(sc.nextInt());
			}
			for(int i = 0;i<m;i++) {
				int attendNum = sc.nextInt();
				pAtt[i] = new int[attendNum];
				for(int j = 0;j<attendNum;j++) {
					pAtt[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			checkMax(pAtt);
			System.out.println(cnt);
			
		}else {
			System.out.println(m);
		}
		
		
	}

	private static void checkMax(int[][] pAtt) {
		v = new boolean[pAtt.length];
		for(int i = 0;i<pAtt.length;i++) {
			if(!v[i]) {
				for(int j = 0;j<pAtt[i].length;j++) {
					if(list.contains(pAtt[i][j])) {
						input(pAtt[i]);
						checkBefore(pAtt, i);
						v[i] = true;
						break;
					}
				}
			}
		}
		
		for(int i = 0;i<pAtt.length;i++) {
			if(!v[i]) {
				cnt++;
			}
		}
		
	}

	private static void checkBefore(int[][] pAtt, int idx) {
		for(int i = 0;i<idx;i++) {
			if(!v[i]) {
				for(int j = 0;j<pAtt[i].length;j++) {
					if(list.contains(pAtt[i][j])) {
						input(pAtt[i]);
						checkBefore(pAtt, i);
						v[i] = true;
						break;
					}
				}
			}
		}
	}

	private static void input(int[] pAtt) {
		for(int i = 0;i<pAtt.length;i++) {
			if(!list.contains(pAtt[i])) {
				list.add(pAtt[i]);
			}
		}
	}

}
