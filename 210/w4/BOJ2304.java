package w4;

import java.util.*;
import java.io.*;

class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = 0;
		int n = Integer.parseInt(br.readLine());
		int[] buildings = new int[1001];
		
		
		int maxIdx = -1, max = -1;
		int leftIdx = 1001, rightIdx = -1;;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if (max < h) {
				maxIdx = idx;
				max = h;
			}

			leftIdx = Math.min(leftIdx, idx);
			rightIdx = Math.max(rightIdx, idx);
			
			buildings[idx] = h;	// 위치
		}
		result += max;
	
		
		int currTarget = buildings[leftIdx];
		int currTargetIdx = leftIdx;
		for (int i = leftIdx + 1; i <= maxIdx; i++) {
			if (currTarget <= buildings[i]) {
				result += ((i - currTargetIdx) * currTarget);
				currTarget = buildings[i];
				currTargetIdx = i;
			}
		}
		
		currTarget = buildings[rightIdx];
		currTargetIdx = rightIdx;
		for (int i = rightIdx; i >= maxIdx; i--) {
			if (currTarget <= buildings[i]) {
				result += ((currTargetIdx - i) * currTarget);
				currTarget = buildings[i];
				currTargetIdx = i;

			}
		}
		 
 		
		System.out.println(result);
	}
}