package SWEA_2;

import java.io.*;
import java.util.*;

public class SWEA_창용마을무리의개수 {

	static int N, M, Ans;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
//			System.out.println(Arrays.toString(parents));
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
//				System.out.println(Arrays.toString(parents));
			}
			for (int i = 1; i < parents.length; i++) {
				if(parents[i] == i) Ans++;
			}
			System.out.println("#"+tc+" "+Ans);
//			System.out.println();
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
