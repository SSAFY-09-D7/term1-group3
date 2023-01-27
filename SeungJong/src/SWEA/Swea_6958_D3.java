package SWEA;

import java.util.Scanner;

public class Swea_6958_D3 {
	static int T, N, M, MaxVal, MaxCount, Count;
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			MaxVal = -1;
			MaxCount = 1;
			for (int i = 0; i < N; i++) {
				Count = 0;
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1) Count += 1;
				}
				if(MaxVal < Count) {
					MaxVal = Count;
					MaxCount = 1;
				}
				else if(MaxVal == Count) {
					MaxCount += 1;
				}
				
			}
			System.out.println("#"+(tc+1)+" "+MaxCount+" "+MaxVal);
		}
		
		sc.close();
	}

}
