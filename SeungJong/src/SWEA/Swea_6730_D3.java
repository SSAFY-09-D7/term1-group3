package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Swea_6730_D3 {
	static int T, N, UpMax, DownMax;
	static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_swea6730.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			UpMax = 0;
			DownMax = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < N-1; i++) {
				if(arr[i+1] - arr[i] > UpMax) UpMax = arr[i+1] - arr[i];
				if(arr[i] - arr[i+1] > DownMax) DownMax = arr[i] - arr[i+1];
			}
	
			System.out.println("#"+tc+" "+UpMax + " " + DownMax);
		}
		
		sc.close();
	}

}
