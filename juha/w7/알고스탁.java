package com.study.w7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고스탁 {
	static int Ms, Ma, L, N, max;
	static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("study.w7/알고스탁.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			data = new int[N][L+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< L+1; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			finding(Ms, 0);
			max = max - Ms - Ma*L;
			System.out.println("#" + test_case + " " + max);
		}
		
	}

	private static void finding(int pocket, int cnt) {
		if(cnt == L) {
			max = Math.max(max, pocket+Ma);
			return;
		}
		if(cnt != 0) pocket = pocket + Ma;
		
		plus = 0;
		buyStock(cnt, pocket, 0);
		finding(pocket + plus, cnt+1);
		
	}
	static int plus;
	private static void buyStock(int cnt, int pocket, int earn) {
		boolean check = false;
		for(int i = 0;i<N;i++) {
			if(data[i][cnt] < data[i][cnt+1] && pocket >= data[i][cnt]) {
				check = true;
				int count = pocket / data[i][cnt];
				buyStock(cnt, pocket-(data[i][cnt]*count), earn + count*(data[i][cnt+1]-data[i][cnt]));
			}
		}
		
		if(!check) {
			plus = Math.max(plus, earn);
			return;		
		}
	}
}
