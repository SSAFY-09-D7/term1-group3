package com.ssafy.study.w3;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SWEA1873 {
	static char[][] tank = { {'U', '^'}, {'D','v'}, {'L', '<'},{'R', '>'}};
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T;test_case++) {
			int h, w;
			h = sc.nextInt();
			w = sc.nextInt();
			
			char[][] map = new char[h][w];
			int[] tankInfo = new int[3];
			
			for(int i=0;i<h;i++) {
				String s = sc.next();
				
				for(int j = 0;j<w;j++) {
					map[i][j] = s.charAt(j);
					if(s.matches("(.*)['v''^''<''>'](.*)")) {
						for(int k = 0;k<4;k++) {
							if(map[i][j] == tank[k][1]) {
								tankInfo[0] = i;
								tankInfo[1] = j;
								tankInfo[2] = k;
							}
						}
						
					}
				}
			}
			int n = sc.nextInt();
			String input = sc.next();
			map = afterGame(map, input, tankInfo);
			System.out.print("#" + test_case + " ");
			
			for(int i = 0;i<map.length;i++) {
				for(int j = 0;j<map[0].length;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	
	public static char[][] afterGame(char[][] map, String input, int[] tankInfo){		
		for(int i = 0;i<input.length();i++) {
			if(input.charAt(i) == 'S') {
				int index = 1;
				while(true) {
					int r = tankInfo[0]+dir[tankInfo[2]][0]*index;
					int c = tankInfo[1]+dir[tankInfo[2]][1]*index++;
					if(r>=0 && c>=0 && r<map.length && c<map[0].length) {
						if(map[r][c] == '*') {
							map[r][c] = '.';
							break;
						}else if(map[r][c] == '#') break;
					}else break;
				}
			}else {
				for(int j = 0;j<4;j++) {
					if(input.charAt(i) == tank[j][0]) {
						map[tankInfo[0]][tankInfo[1]] = tank[j][1];
						tankInfo[2] = j;
						break;
					}
				}
				int index = 1;

				int dr = tankInfo[0] + dir[tankInfo[2]][0]*index;
				int dc = tankInfo[1]+dir[tankInfo[2]][1]*index;
				if(dr>=0 && dc>=0 && dr<map.length && dc<map[0].length) {
					if(map[dr][dc] == '.') {
						map[tankInfo[0]][tankInfo[1]] = '.';
						map[dr][dc] = tank[tankInfo[2]][1];
						tankInfo[0] = dr;
						tankInfo[1] = dc;
					}
				}
			}
		}
		return map;
	}
}
