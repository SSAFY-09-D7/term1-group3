package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_14621_나만안되는연애 {

	static int N, M, Ans;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		v = new boolean[N+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Node>();
		}
		char[] gen = new char[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			gen[i] = st.nextToken().charAt(0);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(1,  0));
		int sum = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(!v[node.end]) {
				v[node.end] = true;
				sum += node.weight;
				for (Node next : list[node.end]) {
					if(!v[next.end] && dist[next.end] > next.weight && gen[next.end] != gen[node.end]) {
						dist[next.end] = next.weight;
						queue.offer(next);
					}
				}
			}
		}
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] > 10000) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(sum);
	}

	private static class Node implements Comparable<Node>{
		int end, weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}