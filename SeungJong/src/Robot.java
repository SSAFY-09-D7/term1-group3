import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Robot {
	static int T, N;
	static char[][] arr;
	static int count = 0;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Robot_input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc <= T; tc++) {
			count = 0;
			N = sc.nextInt();
			arr = new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) arr[i][j] = sc.next().charAt(0);
			}
			int right = 0;
			int left = 0;
			int up = 0;
			int down = 0;
			// A, B, C 찾기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// A를 찾으면 오른쪽으로 최대 빈칸의 개수 더하기
					if(arr[i][j] == 'A') {
						right = j;
						while(true) {
							right += 1;
							if(right > N-1 || arr[i][right] != 'S' ) break;
							count += 1;
						}
					}
					// B를 찾으면 좌, 우로 최대 빈칸의 개수 더하기
					else if(arr[i][j] == 'B') {
						right = j;
						left = j;
						while(true) {
							right += 1;
							if(right > N-1 || arr[i][right] != 'S' ) break;
							count += 1;
						}
						
						while(true) {
							left -= 1;
							if(0 > left || arr[i][left] != 'S' ) break;
							count += 1;
						}
					}
					// C를 찾으면 상, 하, 좌, 우방향의 최대 빈칸의 개수 더하기
					else if(arr[i][j] == 'C') {
						up = i;
						down = i;
						left = j;
						right = j;
						while(true) {
							up -= 1;
							if(up < 0 || arr[up][j] != 'S' ) break;
							count += 1;
						}
						while(true) {
							down += 1;
							if(down > N-1 || arr[down][j] != 'S' ) break;
							count += 1;
						}
						while(true) {
							left -= 1;
							if(0 > left || arr[i][left] != 'S' ) break;
							count += 1;
						}
						while(true) {
							right += 1;
							if(right > N-1 || arr[i][right] != 'S' ) break;
							count += 1;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+count);
			
		}
		
		sc.close();
	}

}
