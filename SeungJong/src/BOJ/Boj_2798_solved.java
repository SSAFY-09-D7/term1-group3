package BOJ;
import java.util.Scanner;

public class Boj_2798_solved {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = 0;
		int maxSum = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					sum = arr[i]+arr[j]+arr[k];
					if(sum <= M && maxSum < sum) maxSum = sum;
				}
			}
		}
		System.out.println(maxSum);
		sc.close();
	}

}
