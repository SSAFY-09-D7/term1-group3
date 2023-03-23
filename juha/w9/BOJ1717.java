package w9;

import java.io.*;
import java.util.*;

public class BOJ1717 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w9/BOJ1717.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i = 0; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				union(b, c);
			}else if(a == 1) {
				if(find(b) == find(c)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int b, int c) {
		int fb = find(b);
		int fc = find(c);
		
		if(fb != fc) {
			arr[fb] = fc;
		}
	}
	
	private static int find(int b) {
		if(arr[b] == b) return b;
		else return arr[b] = find(arr[b]); 
	}

}
