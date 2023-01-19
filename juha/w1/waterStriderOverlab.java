import java.util.*;
import java.lang.*;


public class waterStriderOverlab {

	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
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
				arr[a][b]++;
				if(arr[a][b]>1) wsNum = i+1;
				
				
				dir = sc.nextInt();
				int r = a, c = b;
				for(int j = 3;j>=1;j--) {
					r += dr[dir-1]*j;
					c += dc[dir-1]*j;
					
					if(r>=0 && r<arr.length && c>=0 && c<arr[a].length) {
						arr[r][c]++;
						if(arr[r][c]>1) wsNum = i+1;
					}
					else break;
				}
			}			
			System.out.println("#" + test_case + " " + wsNum);
		}
	}

}
