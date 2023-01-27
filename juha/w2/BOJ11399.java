import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();	
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		
		for(int i = 0;i<n;i++) {
			int smallSum = 0;
			for(int j = 0;j<=i;j++) {
				smallSum += arr[j];
			}
			sum += smallSum;
		}
		System.out.println(sum);
	}

}
