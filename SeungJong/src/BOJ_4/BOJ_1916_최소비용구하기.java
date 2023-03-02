package BOJ_4;

import java.io.*;
import java.util.*;

public class BOJ_1916_최소비용구하기 {

	static int N, M;
	static ArrayList<Vertex>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Vertex>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Vertex(end, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[N+1];
		boolean[] visit = new boolean[N+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		int cur, min;
		for (int i = 1; i < list.length; i++) {
			cur = -1;
			min = INF;
			for (int j = 1; j < list.length; j++) {
				if(!visit[j] && min > distance[j]) {
					cur = j;
					min = distance[j];
				}
			}
			if(cur == -1) break;
			visit[cur] = true;
			if(cur == end) break;
			
			for (Vertex vertex : list[cur]) {
				if(!visit[vertex.end] && distance[vertex.end] > distance[cur]+vertex.weight) {
					distance[vertex.end] = distance[cur] + vertex.weight;
				}
			}
		}
		System.out.println(distance[end]);
		
	}
	
	private static class Vertex{
		int end, weight;
		public Vertex(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}
}
