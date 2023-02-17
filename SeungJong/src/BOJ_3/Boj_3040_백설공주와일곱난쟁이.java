package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_3040_백설공주와일곱난쟁이 {

	static int[] arr = new int[9];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(new int[7], 0, 0);
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k == sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					sb.append(sel[i]+"\n");
				}				
				System.out.println(sb);
			}
			return;
		}
		for (int i = idx; i < 9; i++) {
			sel[k] = arr[i];
			combination(sel, i+1, k+1);
		}
	}

}
