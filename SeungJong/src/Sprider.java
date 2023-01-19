import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sprider {

	static int T, N, num, idxX, idxY, dir;
	static int ans = 0;
	static int [][] arr;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_sprider.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			num = sc.nextInt();
			arr = new int[N][N];
			ans = 0;
			for(int i=0; i<num; i++) {
				boolean isfind = false;
				idxX = sc.nextInt();
				idxY = sc.nextInt();
				dir = sc.nextInt();
				if(!isfind) {
					if(arr[idxX][idxY] == -1) {
						ans = i+1;
						isfind = true;
					}		
				}
				for(int j=3; j>0; j--) {
					if(dir == 1) {
						arr[idxX][idxY] = -1;
						idxX += j;
						if(idxX >= N) break;
						if(!isfind) {
							if(arr[idxX][idxY] == -1) {
								ans = i+1;
								isfind = true;
							}		
						}
					} else {
						arr[idxX][idxY] = -1;
						idxY += j;
						if(idxY >= N) break;
						if(!isfind) {
							if(arr[idxX][idxY] == -1) {
								ans = i+1;
								isfind = true;
							}		
						}
					}
				}
				
			}
			System.out.println("#"+tc+" "+ans);
		}
		
		sc.close();
	}

}
