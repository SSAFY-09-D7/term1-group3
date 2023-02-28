package w7;

import java.io.*;
import java.util.*;

class Main {
	static int N, M, k;
	static int[] needs;
	static int[] parent;
	public static void main(String[] arg) throws Exception {
    	System.setIn(new FileInputStream("./inputs/input_BOJ16562.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        needs = new int[N + 1];
        parent = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	needs[i+1] = Integer.parseInt(st.nextToken());
        }
        
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	union(a, b);
        }
        
        int result = 0;
        for (int i = 1; i <= N; i++) {
        	if (parent[i] == i) result += needs[i];
        }
        
        System.out.println(result <= k ? result : "Oh no");
    }
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (needs[pa] < needs[pb]) {
			parent[pb] = pa;
			
		} else {
			parent[pa] = pb;
			
		}
	}
	
	private static int find(int b) {
		if(parent[b] == b) return b;
		else return find(parent[b]);
	}
	
}