package BOJ_3;

import java.io.*;
import java.util.*;

public class Boj_17471_게리맨더링 {

	static int V, E;
	static ArrayList<Integer>[] list;
	static int[] value;
	static List<Integer> sel = new ArrayList<Integer>();
	static List<Integer> unsel = new ArrayList<Integer>();
	static List<Integer> group1 = new ArrayList<Integer>();
	static List<Integer> group2 = new ArrayList<Integer>();
	static boolean[] visit;
	static int diff = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		value = new int[V+1];
		list = new ArrayList[V+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Integer>();
			value[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			for (int j = 0; j < repeat; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		powerSet(1, new boolean[V+1]);
		System.out.println(diff==Integer.MAX_VALUE?-1:diff);
	}
	private static void powerSet(int idx, boolean[] v) {
		if(idx == V+1) {
			sel.clear();
			unsel.clear();
			group1.clear();
			group2.clear();
			for (int i = 1; i <= V; i++) {
				if(v[i]) {
					sel.add(i);
				}
				else {
					unsel.add(i);
				}
			}
			visit = new boolean[V+1];
			if(sel.size() > 0 && unsel.size()>0) {
				group1 = bfs(sel.get(0), sel);
				group2 = bfs(unsel.get(0), unsel);
			}
			if(group1.size() + group2.size() == V) {
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 1; i <= V; i++) {
					if(group1.contains(i)) {
						sum1 += value[i];
					}
					else if(group2.contains(i)) {
						sum2 += value[i];
					}
				}
				diff = Math.min(diff, Math.abs(sum1 - sum2));
			}
			return;
		}
		v[idx] = true;
		powerSet(idx+1, v);
		v[idx] = false;
		powerSet(idx+1, v);			
	}
	private static List<Integer> bfs(int idx, List<Integer> sel) {
		List<Integer> temp = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		visit[idx] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			temp.add(cur);
			for (int vertex : list[cur]) {
				if(!visit[vertex] && sel.contains(vertex)) {
					queue.offer(vertex);
					visit[vertex] = true;
				}
			}
		}
		return temp;
	}

}
