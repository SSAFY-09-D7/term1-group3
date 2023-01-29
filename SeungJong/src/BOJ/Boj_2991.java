package BOJ;

import java.util.Scanner;

public class Boj_2991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, C, D, P, M, N;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		P = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		int p_count = dogCount(A, B, C, D, P);
		int m_count = dogCount(A, B, C, D, M);
		int n_count = dogCount(A, B, C, D, N);
		System.out.println(p_count);
		System.out.println(m_count);
		System.out.println(n_count);
		sc.close();
	}
	private static int dogCount(int a, int b, int c, int d, int p) {
		int count = 0;
		for (int i = 0;; i++) {
			if(p >= a*i+b*i && p <= a*i+b*i+a) {
				count++;
				break;
			}
			else if(p >= b*i+a*(i+1) && p <= b*(i+1) + a*(i+1)) {
				break;
			}
		}
		for (int i = 0;; i++) {
			if(p >= c*i+d*i && p <= c*i+d*i+c) {
				count++;
				break;
			}
			else if(p >= d*i+c*(i+1) && p <= d*(i+1) + c*(i+1)) {
				break;
			}
		}

		return count;
	}

}
