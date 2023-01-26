package BOJ;

import java.util.Scanner;

public class Boj_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j*i <= N; j++) {
				count += 1;
			}
		}
		System.out.println(count);
		sc.close();
	}

}
