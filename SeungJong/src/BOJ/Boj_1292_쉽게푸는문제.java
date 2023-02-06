package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1292_쉽게푸는문제 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int [B+1];
		int count = 1;
		int sum = 0;
		L:for (int i = 1;; i++) {
			for (int j = 1; j <= i; j++) {
				if(count >= A) {
					sum += i;
				} 
				if(count == B) break L;
				count++;
			}
		}
		sb.append(sum);
		System.out.println(sb);
	}
}
