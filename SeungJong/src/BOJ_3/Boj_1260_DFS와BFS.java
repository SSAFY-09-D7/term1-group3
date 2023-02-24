package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_1260_DFS와BFS {

	static int V, E, Start;
	static int[][] matrix;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Start = Integer.parseInt(st.nextToken());
		matrix = new int[V][V];
		visit = new boolean[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			matrix[from][to] = matrix[to][from] = 1;
		}
		dfs(Start-1);
		System.out.println();
		bfs(Start-1);
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] v = new boolean[V];
		queue.offer(start);
		v[start] = true;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n+1+" ");
			for (int i = 0; i < V; i++) {
				if(matrix[n][i] != 0 && !v[i]) {
					queue.offer(i);
					v[i] = true;
				}
			}
		}
	}

	private static void dfs(int start) {
		visit[start] = true;
		System.out.print(start+1+" ");
		for (int i = 0; i < V; i++) {
			if(matrix[start][i] != 0 && !visit[i]) {
				dfs(i);
			}
		}
	}
}
