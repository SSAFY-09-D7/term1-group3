package com.w7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16562 {
	static int N, M, K;
	static int[][] fee;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("com.w7/BOJ16562.txt")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fee = new int[N+1][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			fee[i][0] = i;
			fee[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		int sum = 0;
		for(int i = 1;i<=N;i++) {
			if(fee[i][0] == i) {
				sum += fee[i][1];
			}
		}
		
		if(sum <= K) System.out.println(sum);
		else System.out.println("Oh no");
		
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			if(fee[pa][1] <= fee[pb][1]) {
				fee[pb][0] = pa;
			}else {
				fee[pa][0] = pb;
			}
		}
		
	}

	private static int find(int a) {
		if(fee[a][0] == a) return a;
		else return fee[a][0] = find(fee[a][0]);
	}

}
