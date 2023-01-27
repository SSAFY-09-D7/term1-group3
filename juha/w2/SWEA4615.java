import java.util.*;
import java.lang.*;

public class SWEA4615 {
	static int[][] dir = {{-1,-1}, {-1,0},{-1,1},{0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
	static int[][] first = { {-1,0}, {0,0}, {0,-1}, {-1,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1;test_case<=T;test_case++) {
			int n, m;
			n = sc.nextInt();
			m = sc.nextInt();
			int[][] checkerboard = new int[n][n];
			
			checkerboard = initialSetUp(n, checkerboard);
			for(int i = 0;i<m;i++) {
				int x, y, color;
				x = sc.nextInt();
				y = sc.nextInt();
				color = sc.nextInt();
				checkerboard = othello(x-1, y-1, color, checkerboard);
			}
			int[] ans = count(checkerboard);
			System.out.println("#" + test_case + " " + ans[1] + " " + ans[2]);
		}

	}
	
	public static int[][] initialSetUp(int n, int[][] checkerboard){
		for(int i = 0;i<4;i++) {
			int dr = (n/2) + first[i][0];
			int dc = (n/2) + first[i][1];
			checkerboard[dr][dc] = i%2+1;
		}
		return checkerboard;
	}
	
	public static int[][] othello(int x, int y, int color, int[][] checkerboard){
		checkerboard[x][y] = color;
		for(int i = 0;i<8;i++) {
			int dr = x+dir[i][0];
			int dc = y+dir[i][1];
			if(dr>=0 && dr<checkerboard.length && dc>=0&&dc<checkerboard[dr].length) {
				if(checkerboard[dr][dc] != color && checkerboard[dr][dc] != 0) {
					checkerboard = swap(dr, dc, i, checkerboard);
				}
			}
		}
		return checkerboard;
	}
	
	public static int[][] swap(int x, int y, int index, int[][] checkerboard){
		int cnt = 0;
		int color = checkerboard[x][y];
		while(true) {
			int dr = x+dir[index][0]*cnt;
			int dc = y+dir[index][1]*cnt;
			if(dr>=0 && dr<checkerboard.length && dc>=0&&dc<checkerboard[dr].length) {
				if(checkerboard[dr][dc] != color ) {
					if(checkerboard[dr][dc] == 0) {
						cnt = 0;
					}
					break;
				}else cnt++;
			}else {
				cnt = 0;
				break;
			}
		}
		
		for(int i = 0;i<cnt;i++) {
			int dr = x+dir[index][0]*i;
			int dc = y+dir[index][1]*i;
			if(color == 1) {
				checkerboard[dr][dc] = 2;
			}else {
				checkerboard[dr][dc] = 1;
			}
		}
		
		return checkerboard;
	}

	public static int[] count(int[][] arr) {
		int[] cnt = new int[3];
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length;j++) {
				cnt[arr[i][j]]++;
			}
		}
		return cnt;
	}
}
