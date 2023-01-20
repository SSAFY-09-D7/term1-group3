import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jump {

	static int T, X, Y, N, dir, jumpLength, sum, boombCount, boombR, boombC;
	static int[][] arr;
	static int[] r;
	static int[] c;
	static int[] jumpCount;
	static boolean isBoomb;
	static boolean isOut;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_jump.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			X = sc.nextInt();  // X좌표
			Y = sc.nextInt();  // Y좌표
			N = sc.nextInt();  // 참가자 수
			sum = -1000 * N;  // 참가비 
			arr = new int[X][Y];  // map
			for(int i=0; i<X; i++) {
				for(int j=0; j<Y; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			r = new int[N];
			c = new int[N];
			jumpCount = new int[N];
			for(int i=0; i<N; i++) {
				r[i] = sc.nextInt()-1;  // 시작지점 X
				c[i] = sc.nextInt()-1;  // 시작지점 Y
				jumpCount[i] = sc.nextInt(); // 점프 횟수
			}
			boombCount = sc.nextInt();   // 폭탄 개수
			for(int i=0; i<boombCount; i++) {
				boombR = sc.nextInt();  // 폭탄 X좌표
				boombC = sc.nextInt();  // 폭탄 Y좌표
				arr[boombR-1][boombC-1] = 0;  // 폭탄 셋팅
			}
			for(int i=0; i<N; i++) {  // 참가자 수 만큼 점프 시작
				isBoomb = false;
				int row = r[i];
				int col = c[i];
				if(arr[row][col] == 0) {  // 시작 지점에 폭탄이 있으면 
					isBoomb = true;
				}
				if(!isBoomb) {  // 폭탄으로 시작하지 않았으면
					for(int j=0; j<jumpCount[i]; j++) {
						if(!isBoomb) {
							dir = arr[row][col]/10;  // 해당 구역의 방향과 점프 거리를 저장
							jumpLength = arr[row][col] % 10;
							switch(dir) {  // 방향과 점프 거리에 맞게 이동
							case 1:
								col += jumpLength;
								if(col > Y-1 || arr[row][col] == 0) {    // 범위 밖으로 나가거나 폭탄이 있으면 Boomb = true
									isBoomb = true;
								}
								break;
							case 2:
								row += jumpLength;
								if(row > X - 1 || arr[row][col] == 0) {
									isBoomb = true;
								}
								break;
							case 3:
								col -= jumpLength;
								if(col < 0 || arr[row][col] == 0) {
									isBoomb = true;
								}
								break;
							case 4:
								row -= jumpLength;
								if(row < 0 || arr[row][col] == 0) {
									isBoomb = true;
								}
								break;
							}		
						}
					}
				}
				if(!isBoomb) {   // 폭탄이 아니었으면 마지막 구역에 100을 곱한 값을 누적
					sum += arr[row][col] * 100;
				}
			}
			System.out.println("#"+tc+" "+sum);		
		}
		sc.close();
	}

}
