package BOJ;

import java.util.Scanner;

public class Boj_2501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans;
		ans = FindKDivisor(N, K);
		System.out.println(ans);	
		sc.close();
	}

	public static int FindKDivisor(int N, int K) {
		int count = 0;
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if(N%i == 0) {
				count ++;
				if(count == K) {
					ans = i;
				}		
			}
		}
		return ans;
	}

}
