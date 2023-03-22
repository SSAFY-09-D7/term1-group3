package w01;

import java.util.*;
import java.io.*;

public class RobotDistances {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./inputs/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			char[][] map = new char[n][n];
					
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					char c = sc.next().charAt(0);
					map[i][j] = c;
				}
			}

			int sum = getDistances(map, n);
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	private static int getDistances(char[][] map, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'A') {
					sum += searchHoriZontalDis(map, n, i, j, 1);
					
				} else if (map[i][j] == 'B') {
					sum += searchHoriZontalDis(map, n, i, j, 1);
					sum += searchHoriZontalDis(map, n, i, j, - 1);
					
				} else if (map[i][j] == 'C') {
					sum += searchHoriZontalDis(map, n, i, j, 1);
					sum += searchHoriZontalDis(map, n, i, j, -1);
					sum += searchVerticalDis(map, n, i, j, 1);
					sum += searchVerticalDis(map, n, i, j, - 1);					
				}
			}
		}
		
		return sum;
	}
	
	private static int searchHoriZontalDis(char[][] map, int n, int r, int c, int d) {
		int dis = 0;
		for (int i = c + d; i < n && i >= 0; i += d) {
			if (map[r][i] != 'S') break;
			dis++;
		}
		
		return dis;
	}
	
	private static int searchVerticalDis(char[][] map, int n, int r, int c, int d) {
		int dis = 0;
		for (int i = r + d; i < n && i >= 0; i += d) {
			if (map[i][c] != 'S') break;
			dis++;
		}
		
		return dis;
	}
	
}
