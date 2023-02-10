package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2961_도영이가만든맛있는음식 {
	
	static int N, ans;
	static Favor[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Favor[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Favor f = new Favor(s, b);
			arr[i] = f;
		}
		powerset(new boolean[N], 0);
		System.out.println(min);
	}
	private static void powerset(boolean[] sel, int idx) {
		if(idx == sel.length) {
			int tempS = 1;
			int tempB = 0;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					tempS *= arr[i].S;
					tempB += arr[i].B;
				}
			}
			if(tempS != 1 && tempB != 0) {
				min = Math.min(min,  Math.abs(tempS - tempB));				
			}
			return;
		}
		sel[idx] = true;
		powerset(sel, idx+1);
		sel[idx] = false;
		powerset(sel, idx+1);
	}

}

class Favor{
	int S;
	int B;
	Favor(int S, int B) {
		this.S = S;
		this.B = B;
	}
	@Override
	public String toString() {
		return "Favor [S=" + S + ", B=" + B + "]";
	}
}
