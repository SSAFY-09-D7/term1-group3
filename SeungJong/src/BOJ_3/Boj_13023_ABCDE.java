package BOJ_3;

import java.util.*;
import java.io.*;

public class Boj_13023_ABCDE {

	static int N, M;
	static ArrayList<Integer>[] adjList; 
	static boolean isFind;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		for (int i = 0; i < N; i++) {
			isFind = false;
			dfs(i, new boolean[N], 0);		
			if(isFind) {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
	}
	private static void dfs(int current, boolean[] visited, int cnt) {
		visited[current] = true;
		if(cnt == 4) {
			isFind = true;
			return;
		}
		
		for (int vertex : adjList[current]) {
			if(!visited[vertex]) {
				dfs(vertex, visited, cnt+1);
				visited[vertex] = false;
			}		
		}
	}

}
