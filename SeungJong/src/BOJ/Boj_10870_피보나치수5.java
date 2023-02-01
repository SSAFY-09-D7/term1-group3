package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10870_피보나치수5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		if(N == 0) ans = 0;
		else if(N == 1) ans = 1;
		else {
			int prev2 = 0;
			int prev1 = 1;
			for (int i = 1; i < N; i++) {
				ans = prev2 + prev1;
				prev2 = prev1;
				prev1 = ans;
			}
		}
			bw.write(sb.append(ans).toString());
			bw.flush();
	}
}
