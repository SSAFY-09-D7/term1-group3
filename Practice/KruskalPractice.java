import java.io.*;
import java.util.*;

public class KruskalPractice {

	static int V, E;
	static ArrayList<Edge> edge = new ArrayList<Edge>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge.add(new Edge(s, e, w));
		}

		// 최소 가중치 출력
		System.out.println(kruskal());
	}

	private static int kruskal() {
		int min = Integer.MAX_VALUE;

		return min;
	}

	private static class Edge {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

	}

}
