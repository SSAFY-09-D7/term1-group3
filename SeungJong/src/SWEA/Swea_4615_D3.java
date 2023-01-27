package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Swea_4615_D3 {
	static int T, N, R, C, Dir, M;
	static int[][] arr;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int nr, nc, K, count1, count2;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_4615.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			count1 = 0;
			count2 = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			arr[N/2-1][N/2-1] = 2; // 2 = 백, 1 = 흑
			arr[N/2-1][N/2] = 1;
			arr[N/2][N/2-1] = 1;
			arr[N/2][N/2] = 2;
			for (int i = 0; i < M; i++) {
				R = sc.nextInt()-1;
				C = sc.nextInt()-1;
				Dir = sc.nextInt(); // 2 = 백 , 1 = 흑
				arr[R][C] = Dir;
				for (int j = 0; j < 8; j++) {
					nr = R + dr[j];
					nc = C + dc[j];
					K = 2;
					if(!(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)) {			
						if(Dir == 1) { // 흑돌이면 주위에 백돌이 있는지
							if(arr[nr][nc] == 2) {
								while(true) {
									nr = R + dr[j]*K;
									nc = C + dc[j]*K;
									if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) break;
									if(arr[nr][nc] == 0) break;
									if(arr[nr][nc] == 1) {
										for(int l=1; l<K; l++) {
											arr[R+(dr[j]*l)][C+(dc[j]*l)] = 1;
										}
										break;
									}
									K++;
								}
							}
						}
						else if(Dir == 2) { // 백돌이면 주위에 흑돌이 있는지
							if(arr[nr][nc] == 1) {
								while(true) {
									nr = R + dr[j]*K;
									nc = C + dc[j]*K;
									if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) break;
									if(arr[nr][nc] == 0) break;
									if(arr[nr][nc] == 2) {
										for(int l=1; l<K; l++) {
											arr[R+dr[j]*l][C+dc[j]*l] = 2;
										}
										break;
									}
									K++;
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 1) count1 += 1;
					else if(arr[i][j] == 2) count2 += 1;
				}
				
			}
			System.out.println("#"+tc+" "+count1+" "+count2);
		}
		sc.close();
	}

}
