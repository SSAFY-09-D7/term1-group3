package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1978_소수찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			count += isPrime(Integer.parseInt(st.nextToken()));
		}
		bw.write(count+"");
		bw.flush();
	}

	private static int isPrime(int n) {
		if(n == 1) return 0;
		if(n == 2) return 1;
		for (int i = 2; i < n; i++) {
			if(n%i == 0) return 0;
		}
		return 1;
	}
}
