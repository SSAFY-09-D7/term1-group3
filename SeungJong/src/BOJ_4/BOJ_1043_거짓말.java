package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_1043_거짓말 {
	static int N, M, Ans;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) parents[i] = i;
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if(num>0) {
			for (int i = 0; i < num; i++) {
				int temp = Integer.parseInt(st.nextToken());
				parents[temp] = 0;
			}
		}
		int[][] meeting = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int peopleNum = Integer.parseInt(st.nextToken());
			meeting[i] = new int[peopleNum];
			for (int j = 0; j < peopleNum; j++) {
				meeting[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < peopleNum-1; j++) {
				union(meeting[i][j], meeting[i][j+1]);
			}
		}
		for (int i = 0; i < M; i++) {
			boolean flag = false;
			for (int j = 0; j < meeting[i].length; j++) {
				if(find(meeting[i][j]) == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) Ans++;
		}
		System.out.println(Ans);
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) {
			if(pa == 0) parents[pb] = pa;
			else parents[pa] = pb;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

}
