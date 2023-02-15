package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_6603_로또 {

	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			if(check == 0) break;
			arr = new int[check];
			for (int i = 0; i < check; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(new int[6], 0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		if(idx == arr.length) return;
		sel[k] = arr[idx];
		combination(sel, idx+1, k+1);
		combination(sel, idx+1, k);
	}

}
