package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arrList.add(sc.nextInt());
		}
		Collections.sort(arrList);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				sum += arrList.get(j);
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
