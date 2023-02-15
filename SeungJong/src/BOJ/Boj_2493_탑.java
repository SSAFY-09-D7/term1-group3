package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int index = findIndex(arr, i);
			sb.append(+index+" ");
		}
		System.out.println(sb);
	}

	private static int findIndex(int[] arr, int i) {
		int index = 0;
		for (int j = i; j >= 0; j--) {
			if(arr[i] < arr[j]) {
				index = j;
				if(index != 0 || j==0) index ++;
				break;
			}
		}
		return index;
	}

}
