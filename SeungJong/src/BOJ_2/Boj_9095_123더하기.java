package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_9095_123더하기 {

	static int Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			Ans = 0;
			for (int j = 1; j <= temp; j++) {
//				combination(new int[j], 0, 0, temp);
				permutation(new int[j], 0, temp);
			}
			sb.append(Ans+"\n");
		}
		System.out.println(sb);
	}

	private static void permutation(int[] sel, int k, int temp) {
		if(k == sel.length) {
			int t = 0;
			for (int i = 0; i < sel.length; i++) {
				t += sel[i];
			}
			if(t==temp) Ans++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			sel[k] = i+1;
			permutation(sel, k+1, temp);
		}
	}	

}
