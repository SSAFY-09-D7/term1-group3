package SWEA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Swea_1873_D3 {
	static int T, X, Y, N, Dir, StartX, StartY;
	static char[][] arr;
	static char[] Move;
	static String tmp;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_swea1873.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			arr = new char[X][Y];
			for (int i = 0; i < X; i++) {
				tmp = sc.next();
				for (int j = 0; j < Y; j++) {
					arr[i][j] = tmp.charAt(j);
					if(arr[i][j] == '^') {
						Dir = 1; 
						StartX = i;
						StartY = j; 
					}
					switch (arr[i][j]) {
					case '^':
						Dir = 1; 
						StartX = i;
						StartY = j; 
						break;
					case '>':
						Dir = 2; 
						StartX = i;
						StartY = j; 
						break;
					case 'v':
						Dir = 3; 
						StartX = i;
						StartY = j; 
						break;
					case '<':
						Dir = 4; 
						StartX = i;
						StartY = j; 
						break;
					}
				}
			}
			N = sc.nextInt();
			Move = new char[N];
			tmp = sc.next();
			for (int j = 0; j < N; j++) {
				Move[j] = tmp.charAt(j);
				switch(Move[j]) {
				case 'S':
					if(Dir == 1) {
						for (int j2 = 1; StartX - j2 >= 0 ; j2++) {
							if(arr[StartX-j2][StartY] == '*') {
								arr[StartX-j2][StartY] = '.';
								break;
							}
							else if(arr[StartX-j2][StartY] == '#') break;
								
						}
					}
					else if(Dir == 2) {
						for (int j2 = 1; StartY + j2 < Y ; j2++) {
							if(arr[StartX][StartY + j2] == '*') {
								arr[StartX][StartY + j2] = '.';
								break;
							}
							else if(arr[StartX][StartY + j2] == '#') break;
								
						}	
					}
					else if(Dir == 3) {
						for (int j2 = 1; StartX + j2 < X ; j2++) {
							if(arr[StartX+j2][StartY] == '*') {
								arr[StartX+j2][StartY] = '.';
								break;
							}
							else if(arr[StartX+j2][StartY] == '#') break;
							
						}
					}
					else if(Dir == 4) {
						for (int j2 = 1; StartY - j2 >= 0 ; j2++) {
							if(arr[StartX][StartY - j2] == '*') {
								arr[StartX][StartY - j2] = '.';
								break;
							}
							else if(arr[StartX][StartY - j2] == '#') break;
									
						}
					}
						
					break;
				case 'U':
					Dir = 1;
					arr[StartX][StartY] = '^';
					if(StartX -1 >=0 && arr[StartX-1][StartY] == '.') {
						arr[StartX][StartY] = '.';
						StartX -= 1;
						arr[StartX][StartY] = '^';
					}
					break;
				case 'R':
					Dir = 2;
					arr[StartX][StartY] = '>';
					if(StartY + 1 < Y && arr[StartX][StartY+1] == '.') {
						arr[StartX][StartY] = '.';
						StartY += 1;
						arr[StartX][StartY] = '>';
					}
					break;
				case 'D':
					Dir = 3;
					arr[StartX][StartY] = 'v';
					if(StartX +1 < X && arr[StartX+1][StartY] == '.') {
						arr[StartX][StartY] = '.';
						StartX += 1;
						arr[StartX][StartY] = 'v';
					}
					break;
				case 'L':
					Dir = 4;
					arr[StartX][StartY] = '<';
					if(StartY -1 >=0 && arr[StartX][StartY-1] == '.') {
						arr[StartX][StartY] = '.';
						StartY -= 1;
						arr[StartX][StartY] = '<';
					}
					break;
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < X; i++) {
				for (int k = 0; k < Y; k++) {
					System.out.printf("%c",arr[i][k]);
				}
				System.out.println("");
			}
		}
		sc.close();
	}
}
