package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2609_최대공약수최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int min = Math.min(n1, n2);
		for (int i = min; i >= 0; i--) {
			if(n1 % i == 0 && n2 % i == 0) {
				sb.append(i+"\n");
				break;
			}
		}
		int num1 = n1;
		int num2 = n2;
		while(num1!=num2) {
			if(num1 < num2) num1 += n1;
			else num2 += n2;
		}
		sb.append(num1);
		System.out.println(sb);
	}

}
