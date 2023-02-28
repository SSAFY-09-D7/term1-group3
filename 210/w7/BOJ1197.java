package w7;

import java.io.*;
import java.util.*;

class Main {
	static int[] parent;
	static long result = 0;
	
	public static void main(String[] arg) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ1197.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        
        for (int i = 0; i < m; i ++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	edges.offer(new Edge(a, b, w));
        }
        
        
        search(edges, n);
        
        System.out.println(result);
    }
	
	private static void search(PriorityQueue<Edge> edges, int n) {
		int cnt = 0;
        while(!edges.isEmpty()) {
        	Edge e = edges.poll();
        	

        	if (find(e.start) == find(e.end)) continue;
        	union(e.start, e.end);
        	result += e.weight;
        	cnt++;
        	
        	if (cnt == n - 1) break;
        }
	}
	
	
	private static void union(int a, int b) {
		if (parent[a] <  parent[b]) {
			parent[parent[b]] = parent[a];			
		
		} else if (parent[a] >  parent[b]) {
			parent[parent[a]] = parent[b];
		}
	}
	
	private static int find(int k) {
		if (k == parent[k]) {
			return k;
		}
		return parent[k] = find(parent[k]);
	}
	
	static class Edge {
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}
	}
 
}