package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_16562_친구비 {

	static int N, M, K, Ans;
	static int[] parents, value;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		value = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(value[find(a)] > value[find(b)]) union(a, b);
//			if(value[a] > value[b]) union(a, b);
			else union(b, a);
		}
		for (int i = 1; i <= N; i++) {
			if(parents[i] == i) {
				Ans += value[i];
			}
		}
		System.out.println(Ans>K?"Oh no":Ans);
	}
	private static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if(ra!=rb) {
			parents[ra] = rb;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

}
