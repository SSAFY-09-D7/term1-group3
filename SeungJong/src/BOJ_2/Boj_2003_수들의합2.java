package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = 0;
		int ans = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = arr[0];
		while(start!=N-1 || end != N-1) {
			if(sum == M ) {
				ans++;
			}
			if(end != N-1 && sum < M) {
				end++;
				sum += arr[end];
			}
			else {
                sum -= arr[start];
				start++;
			}
		}
        if(arr[N-1] == M) ans++;
		System.out.println(ans);
	}
}
