package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_14888_연산자끼워넣기 {

	static int[] nums;
	static ArrayList<Integer> op = new ArrayList<Integer>();
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		int[] temp = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp[i]; j++) {
				op.add(i);				
			}
		}
		
		permutation(new int[N-1], 0, new boolean[N-1]);
		System.out.println(max);
		System.out.println(min);

	}
	private static void permutation(int[] sel, int k, boolean[] v) {
		if(k == sel.length) {
			calcVal(sel);
			return;
		} else {
			for (int i = 0; i < op.size(); i++) {
				if(!v[i]) {
					v[i] = true;
					sel[k] = op.get(i);
					permutation(sel, k+1, v);
					v[i] = false;
				}
			}
		}
	}
	private static void calcVal(int[] sel) {
		int value = 0;
		switch (sel[0]) {
		case 0:
			value = nums[0] + nums[1]; break;
		case 1:
			value = nums[0] - nums[1]; break;
		case 2:
			value = nums[0] * nums[1]; break;
		case 3:
			value = nums[0] / nums[1]; break;
		}
		for (int i = 1; i < sel.length; i++) {
			switch (sel[i]) {
			case 0:
				value = value + nums[i+1]; break;
			case 1:
				value = value - nums[i+1]; break;
			case 2:
				value = value * nums[i+1]; break;
			case 3:
				value = value / nums[i+1]; break;
			}
		}
		min = Math.min(min, value);
		max = Math.max(max, value);
	}

}
