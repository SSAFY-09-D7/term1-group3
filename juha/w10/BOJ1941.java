package w11;

import java.io.*;
import java.util.*;

public class BOJ1941 {
	static char[][] seat;
	static int cnt;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("w11/BOJ1941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		seat = new char[5][5];
		cnt = 0;
		
		for(int i = 0; i<5; i++) {
			String s = br.readLine();
			for(int j = 0; j<5; j++) {
				seat[i][j] = s.charAt(j);
			}
		}
		
		comb(new int[7], 0 , 0);
		
		System.out.println(cnt);
	}
	
	private static void comb(int[] sel, int cur, int start) {
		if(cur == sel.length) {
			if(isAvailable(sel)) {
				int yCnt = 0;
				for(int i = 0; i<sel.length; i++) {
					if(seat[sel[i]/5][sel[i]%5]=='Y') yCnt++;
				}
				if(yCnt <= 3) {
					cnt++;
				}
			}
			return;
		}
		
		for(int i = start; i<25; i++) {
			sel[cur] = i;
			comb(sel, cur+1, i+1);
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	private static boolean isAvailable(int[] sel) {
		int[] find = {5,-5,1,-1};
		Queue<Integer> queue = new LinkedList<>();
		boolean[] v = new boolean[7];
		queue.offer(sel[0]);
		v[0] = true;
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for(int d = 0; d<4; d++) {
				int temp = a + find[d];
				
				if(temp < 0 || temp >= 25) continue;
				if((d == 2 || d==3) && temp/5 != a/5 ) continue;
				
				for(int j = 0; j<sel.length; j++) {
					if(sel[j] == temp && !v[j]) {
						v[j] = true;
						queue.offer(temp);
					}
				}
			}
		}
		
		for(int i = 0; i<sel.length; i++) {
			if(!v[i]) return false;
		}
		
		return true;
	}

}
