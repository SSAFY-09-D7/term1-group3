package w4;

import java.util.*;
import java.io.*;


class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./inputs/input_BOJ14719.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		int result = 0;
		int w = Integer.parseInt(st.nextToken());
		int[] blocks = new int[w];
		
		st = new StringTokenizer(br.readLine());
		int firstIdx = -1, lastIdx = w+1;
		for (int i = 0; i < w; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
			if (firstIdx == -1 && blocks[i] != 0) {
				firstIdx = i;
			}
			
			if (blocks[i] != 0) lastIdx = i;
		}
		
		
		int currMax = blocks[firstIdx];
		for (int i = firstIdx; i <= lastIdx; i++) {
			if (s.isEmpty()) {
				s.push(blocks[i]);
			} else if (blocks[i] <= currMax) {
				s.push(blocks[i]);
			} else if (blocks[i] > currMax) {
				while(!s.isEmpty()) {
					int num = s.pop();
					int add = currMax - num > 0? currMax - num : 0;
					result += add;
				}
			}
		}
	
		int top = blocks[lastIdx];
		while(!s.isEmpty()) {
			int num = s.pop();
			int add = top - num > 0? top - num : 0;
			result += add;
		}
		
		System.out.println(result);
	}
}