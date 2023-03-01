package BOJ_4;

import java.io.*;
import java.util.*;


public class BOJ_1197_최소스패닝트리 {

	private static class Edge{
		int s, e, w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	static int V, E;
	static Edge[] edge;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(start, end, weight);
		}
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		int sum = 0, count = 0;
		for (int i = 0; i < edge.length; i++) {
			int s = edge[i].s;
			int e = edge[i].e;
			if(find(s) != find(e)) {
				count++;
				sum += edge[i].w;
				union(s, e);					
				if(count == V-1) break;
			}
		}
		System.out.println(sum);
	}
	
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) parents[pa] = pb;
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

}
