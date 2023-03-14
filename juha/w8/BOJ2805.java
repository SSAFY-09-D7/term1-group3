package w8;

import java.io.*;
import java.util.*;

public class BOJ2805 {
	static int N, M;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w8/BOJ2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			tree[i] = Long.parseLong(st.nextToken());
			
		}
		Arrays.sort(tree);
		maxTreeHeight();
	}

	private static void maxTreeHeight() {
		int cnt = 1, length = 0;
		long sum = 0;
		long first = tree[tree.length-1];
		for(int i = tree.length-1; i > 0; i--) {
			tree[i] = tree[i] - tree[i-1];
		}
		int idx = tree.length-1;
		while(sum < M && idx>=0) {
			if(tree[idx]*cnt + sum <= M) {
				sum += tree[idx]*cnt;
				length += tree[idx];
				tree[idx] = 0;
				idx--;
				cnt++;
				continue;
			}
			
			tree[idx]--;
			sum += cnt;
			if(tree[idx] == 0) {
				idx--;
				cnt++;
			}
			length++;
		}
		
		System.out.println(first - length);
	}

}
