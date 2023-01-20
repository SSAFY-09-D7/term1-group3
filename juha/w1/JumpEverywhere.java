import java.util.*;
import java.lang.*;

public class JumpEverywhere {

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};//동남서북
	public static int price(int[][] arr, int[] att) {
		int r = att[0]-1, c = att[1]-1;
		for(int i = 1;i<=att[2];i++) {
			int dir, distance;
			dir = arr[r][c]/10;
			distance = arr[r][c]%10;
			r = r + dr[dir-1]*distance;
			c = c + dc[dir-1]*distance;
			
			if(r>=0 && r<arr.length && c>=0 && c<arr[att[0]-1].length) {
				if(arr[r][c] == 0) return -1000;
				if(i == att[2]) return arr[r][c]*100 - 1000;
			}
			else return -1000;
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int y, x, n;
			y = sc.nextInt();
			x = sc.nextInt();
			n = sc.nextInt();
			
			int[][] arr = new int[y][x];
			for(int i = 0;i<y;i++) {
				for(int j = 0;j<x;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] att = new int[n][3];
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<3;j++) {
					att[i][j] = sc.nextInt();
				}
			}
			
			int bombNum;
			bombNum = sc.nextInt();
			for(int i = 0;i<bombNum;i++) {
				int r, c;
				r = sc.nextInt();
				c = sc.nextInt();
				arr[r-1][c-1] = 0;
			}
			
			int sum = 0;
			for(int i = 0;i<n;i++) {
				sum += price(arr, att[i]);
			}
			System.out.println("#"+ test_case + " " + sum);
		}
	}

}
