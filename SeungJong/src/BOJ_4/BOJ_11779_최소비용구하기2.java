package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {
	static int N, M;
	static ArrayList<Node>[] list;
	static ArrayList<Integer> visitNode = new ArrayList<Integer>();
	static int[] route;
	static int[] dist;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		route = new int[N+1];
		v = new boolean[N+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(start, 0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(!v[node.end]) {
				v[node.end] = true;
				for (Node next : list[node.end]) {
					if(!v[next.end] && dist[next.end] > dist[node.end] + next.wieght) {
						dist[next.end] = dist[node.end] + next.wieght;
						queue.offer(new Node(next.end, dist[next.end]));
						route[next.end]= node.end; 
					}
				}
			}
		}
		System.out.println(dist[end]);
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		int cnt = 1;
		while(route[end] != 0) {
			cnt += 1;
			stack.push(route[end]);
			end = route[end];
		}
		System.out.println(cnt);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() +" ");
		}
		
	}
	private static class Node implements Comparable<Node>{
		int end, wieght;
		public Node(int end, int wieght) {
			super();
			this.end = end;
			this.wieght = wieght;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.wieght, o.wieght);
		}
	}
}
