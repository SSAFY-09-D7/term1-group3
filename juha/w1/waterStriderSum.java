import java.util.*;
import java.lang.*;

public class waterStriderSum {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1;test_case<=T;test_case++) {
			int n, ws;
			n = sc.nextInt();
			ws = sc.nextInt();
			int[][] arr = new int[n][n];
			int wsNum = 0;
				
			for(int i = 0;i<ws;i++) {
				int a, b, dir;
				a = sc.nextInt();
				b = sc.nextInt();
				dir = sc.nextInt();
				if(arr[a][b]==1) break;
				
				int r = a, c = b;
				for(int j = 3;j>=1;j--) {
					r += dr[dir-1]*j;
					c += dc[dir-1]*j;
					
					if(r>=0 && r<arr.length && c>=0 && c<arr[a].length) {
						if(arr[r][c] == 1) break;
						else {
							if(j == 1) { arr[r][c]++; wsNum++;}
						}
					}
					else break;
				}
			}
			
			System.out.println("#" + test_case + " " + wsNum);
		}
	}

}
