package BOJ;

import java.util.Scanner;

public class Boj_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int strLength = str.length();
		int R = 0, C = 0;
		for (int i = 1; i <= strLength/2; i++) {
			if(strLength % i == 0 && C >= R) {
				C = strLength / i;
				if(C >= i) R = i;
			}
		}
		C = strLength / R;
		char[] carr = str.toCharArray();
		int length = 0;
		char[][] arr = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = carr[length++];
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.printf("%c",arr[i][j]);
			}
		}

		sc.close();
	}
	

}
