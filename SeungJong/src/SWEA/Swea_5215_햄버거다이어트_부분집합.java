package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_5215_햄버거다이어트_부분집합 {
	static int N;
	static int L;
	static Hambuger[] arr;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new Hambuger[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int favor = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				Hambuger temp = new Hambuger(favor, cal);
				arr[i] = temp;
			}

			powerset(new boolean[N], 0);
			System.out.println("#"+tc+" "+max);
		}
	}
	private static void powerset(boolean[] sel, int idx) {
		if(idx == sel.length) {
			int cal = 0;
			int favor = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					cal += arr[i].cal;
					favor += arr[i].favor;
				}
			}
			if(cal<=L) {
				max = Math.max(max, favor);
			}
			return;
		}
		sel[idx] = true;
		powerset(sel, idx+1);
		sel[idx] = false;
		powerset(sel, idx+1);
		
	}

	public static class Hambuger{
		int favor;
		int cal;
		Hambuger(int favor, int cal) {
			this.favor = favor;
			this.cal = cal;
		}
		@Override
		public String toString() {
			return "Hambuger [favor=" + favor + ", cal=" + cal + "]";
		}
	}
}
