import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sprider2 {

	static int T, N, num, idxX, idxY, dir, count;
	static int ans = 0;
	static int [][] arr;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_spride2r.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			num = sc.nextInt();
			count = num;
			arr = new int[N][N];
			for(int i=0; i<num; i++) {
				boolean isOut = false;
				idxX = sc.nextInt();
				idxY = sc.nextInt();
				dir = sc.nextInt();
				// 시작 지점에 다른 소금쟁이가 있으면 개수 -1
				if(arr[idxX][idxY] == -1) {
					count -= 1;
				}
				else { // 방향에 따른 switch case
					switch(dir) {
					case 1:  // 해당 방향으로 점프를 뛰는데 범위를 벗어나거나 해당 지역에 소금쟁이가 있으면 개수를 줄임
						for(int j=3; j>0; j--) {
							idxX -= j;
							if (idxX<0 ) {
								count -= 1;
								isOut = true;
								break;
							}
							else if(arr[idxX][idxY]== -1) {
								count -= 1;
								break;
							}
						}
						if(!isOut) arr[idxX][idxY] = -1;
						break;
					case 2:
						for(int j=3; j>0; j--) {
							idxX += j;
							if (idxX>N-1 ) {
								count -= 1;
								isOut = true;
								break;
							}
							else if(arr[idxX][idxY]== -1) {
								count -= 1;
								break;
							}
						}
						if(!isOut) arr[idxX][idxY] = -1;
						break;
					case 3:
						for(int j=3; j>0; j--) {
							idxY -= j;
							if (idxY<0 ) {
								count -= 1;
								isOut = true;
								break;
							}
							else if(arr[idxX][idxY]== -1) {
								count -= 1;
								break;
							}
						}
						if(!isOut) arr[idxX][idxY] = -1;
						break;
					case 4:
						for(int j=3; j>0; j--) {
							idxY += j;
							if (idxY>N-1 ) {
								count -= 1;
								isOut = true;
								break;
							}
							else if(arr[idxX][idxY]== -1) {
								count -= 1;
								break;
							}
						}
						if(!isOut) arr[idxX][idxY] = -1;
						break;
					}
					
				}
			}
			System.out.println("#"+tc+" "+count);
		}
		sc.close();
	}
}