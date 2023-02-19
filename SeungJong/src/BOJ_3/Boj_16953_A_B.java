package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16953_A_B {

	static Long Ans = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long N = Long.parseLong(st.nextToken());
		Long M = Long.parseLong(st.nextToken());
		dfs(Long.toString(N), M, 1);
		System.out.println(Ans==Long.MAX_VALUE?-1:Ans);
	}
	private static void dfs(String n, Long m, int cnt) {
		if(Long.parseLong(n) >= m) {
			if(Long.parseLong(n)==m) Ans = Math.min(Ans, cnt);
			return;
		}
		Long tmp = Long.parseLong(n);
		tmp *= 2;
		dfs(Long.toString(tmp), m, cnt+1);
		dfs(n+1, m, cnt+1);
	}

}
