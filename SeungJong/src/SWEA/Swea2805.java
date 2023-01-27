package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Swea2805 {
	static int T, N, sum, start, finish;
	static String V;
	static int[][] arr;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_swea2805.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sum = 0;
			N = sc.nextInt();
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				V = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] =V.charAt(j) - '0';
				}
			}
			start = N/2;
			finish =N/2;
			for(int i=0; i<N/2+1; i++) {
				for(int j=start; j<=finish; j++) {
					sum += arr[i][j];
				}
				start -= 1;
				finish += 1;
			}
			start = 1;
			finish = N-1;
			for(int i=N/2+1; i<N; i++) {
				for(int j = start; j<finish; j++) {
					sum += arr[i][j];
				}
				start += 1;
				finish -= 1;
			}
			System.out.println("#"+tc+" "+sum);
			
		}
		sc.close();
	}

}
