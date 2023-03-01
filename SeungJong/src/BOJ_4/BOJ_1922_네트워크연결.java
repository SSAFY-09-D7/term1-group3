package BOJ_4;

import java.io.*;
import java.util.*;

public class BOJ_1922_네트워크연결 {
	static int N, M;
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edge.add(new Edge(from, to, weight));
		}
		
		Collections.sort(edge);
		
		int sum = 0, cnt = 0;
		for (int i = 0; i < edge.size(); i++) {
			Edge temp = edge.get(i);
			int pa = temp.s;
			int pb = temp.e;
			if(find(pa) == find(pb)) continue;
			sum += temp.w;
			cnt++;
			union(pa, pb);
			if(cnt == N-1) break;
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

	private static class Edge implements Comparable<Edge>{
		int s, e, w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

}
