package com.w5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class BOJ14503 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1}; // 북 동 남 서

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("BOJ14503.txt"));
		//Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		
		int[] robot = new int[3];
		
		for(int i = 0;i<3;i++) {
			robot[i] = sc.nextInt();
		}
		for(int i = 0;i<map.length;i++) {
			for(int j = 0;j<map[i].length;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		cleanHouse(map, robot);
	}

	private static void cleanHouse(int[][] map, int[] robot) {
		int robotMove = 0;
		if(map[robot[0]][robot[1]] == 0) {
			int cleanNum = 2;
			map[robot[0]][robot[1]] = cleanNum++;
			robot[2] = (robot[2]==0) ? 4 : robot[2];
			robot[2]--;
			robotMove++;
			int r, c;
			int cnt = 0;
			while(true) {
				if(cnt == 5) {
					robot[2] = (robot[2]==0) ? 4 : robot[2];
					robot[2]++;
					r = robot[0] - dr[robot[2]%4];
					c = robot[1] - dc[robot[2]%4];
					if(map[r][c] != 1) {
						robot[0] = r;
						robot[1] = c;
						cnt = 0;
					}else {
						break;
					}
				}else {
					r = robot[0] + dr[robot[2]%4];
					c = robot[1] + dc[robot[2]%4];
					if(map[r][c] == 0) {
						map[r][c] = cleanNum++;
						robot[0] = r;
						robot[1] = c;
						cnt = 0;
						robotMove++;
						robot[2] = (robot[2]==0) ? 4 : robot[2];
						robot[2]--;
						cnt++;						
					}else {
						cnt++;
						robot[2] = (robot[2]==0) ? 4 : robot[2];
						robot[2]--;
					}
				}
				
			}
		}
		
		System.out.println(robotMove);
	}

}
