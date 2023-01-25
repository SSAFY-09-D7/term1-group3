import java.util.*;
import java.lang.*;

public class MazeArrived {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};//북 동 남 서
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1;test_case<=T;test_case++) {
			int n, a, b, jumper;
			n = sc.nextInt();
			a = sc.nextInt()-1;
			b = sc.nextInt()-1;
			jumper = sc.nextInt();
			
			int[][] arr = new int[n][n];
			for(int i = 0;i<jumper;i++) {
				arr[sc.nextInt()-1][sc.nextInt()-1] = 1;
			}
			int dirNum;
			dirNum = sc.nextInt();
			for(int i = 0;i<dirNum;i++) {
				int dir, num;
				dir = sc.nextInt();
				num = sc.nextInt();
				for(int j = 0;j<num;j++) {
					int r = a + dr[dir-1];
					int c = b + dc[dir-1];
					if(r>=0 && r<arr.length && c>=0 && c<arr[r].length) {
						if(arr[r][c] == 1) {
							a = -1; b = -1;
							break;
						}else {
							a = r; b = c;
						}
					} else {
						a = -1; b = -1;
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + (a+1) + " " + (b+1));
		}

	}

}
