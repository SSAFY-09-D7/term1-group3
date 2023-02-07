package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2581_소수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean isFind = false;
		int minVal = 0;
		int sum = 0;
		for (int i = N; i <= M; i++) {
			if(isPrime(i)) {
				if(!isFind) {
					minVal = i;
					isFind = true;
				}
				sum += i;
			}
		}
		if(!isFind) System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(minVal);
		}
	}

	private static boolean isPrime(int n) {
		if(n==1) return false;
		if(n==2) return true;
		for (int i = 2; i < n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}

}
