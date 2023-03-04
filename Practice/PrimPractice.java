import java.io.*;
import java.util.*;

public class PrimPractice {

	static int V, E;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V];

		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<Node>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, w));
			list[e].add(new Node(s, w));
		}

		// 최소 가중치 MST 출력
		System.out.println(prim());
	}

	private static int prim() {
		int min = Integer.MAX_VALUE;

		return min;
	}

	private static class Node implements Comparable<Node> {
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
