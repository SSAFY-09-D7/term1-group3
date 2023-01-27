package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = 0;
		int maxSum = 0;
		ArrayList<Integer> arrList = new ArrayList<>();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i < (1<<N); i++) {
			sum = 0;
			arrList.clear();
			for (int j = 0; j < N; j++) {
				int bol = i & (1<<j);
				if(bol>0) {
					arrList.add(arr[j]);
				}
			}
			if(arrList.size() == 3 && (arrList.get(0) + arrList.get(1) +arrList.get(2)) <= M) {
				sum = arrList.get(0) + arrList.get(1) +arrList.get(2);
			}
			if(maxSum < sum) {
				maxSum = sum;
			}
		}
		
		System.out.println(maxSum);
		sc.close();
	}

}
