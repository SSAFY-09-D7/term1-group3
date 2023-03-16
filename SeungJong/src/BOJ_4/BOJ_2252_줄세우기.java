package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_2252_줄세우기 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] inDegree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		inDegree = new int[N+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int start, end;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			inDegree[end]++;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp = bfs();
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
		}
	}
	private static ArrayList<Integer> bfs() {
		ArrayList<Integer> order = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i < list.length; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			order.add(cur);
			for (Integer next : list[cur]) {
				if(--inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		return order;
	}
}
