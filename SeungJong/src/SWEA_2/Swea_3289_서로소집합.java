package SWEA_2;

import java.io.*;
import java.util.*;

public class Swea_3289_서로소집합 {

	static StringBuilder sb;
	static int N, M;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(type == 0) {
					union(a, b);
				}
				else {
					int findA = find(a);
					int findB = find(b);
					if(findA == findB) sb.append("1");
					else sb.append("0");
				}
			}
			System.out.println("#"+tc+" "+sb);
		}
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa!=pb) {
			parents[pa] = pb;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

}
