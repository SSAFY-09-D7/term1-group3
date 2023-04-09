package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_1202_보석도둑 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel[] jewel = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(jewel);
		int[] weight = new int[K];
		for (int i = 0; i < K; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(weight);
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		long sum = 0;
		for (int i = 0, index = 0; i < K; i++) {
			while(index < N && jewel[index].w <= weight[i]) {
				queue.offer(jewel[index++].v);
			}
			if(!queue.isEmpty()) sum += queue.poll();
		}
		System.out.println(sum);
	}
	private static class Jewel implements Comparable<Jewel>{
		int w, v;

		public Jewel(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			if(this.w == o.w) return Integer.compare(o.v, this.v);
			return Integer.compare(this.w, o.w);
		}

		@Override
		public String toString() {
			return "Jewel [w=" + w + ", v=" + v + "]";
		}
	}
}
