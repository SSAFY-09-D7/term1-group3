package SWEA.SWEA3;

/*
 * 한 열씩 탐색, 한 행씩 탐색 후
 * 높이가 차이나는 곳에서 경사로를 놓을 수 있는지 확인
 * 놓을 수 없으면 건설 불가능
 * 놓을 수 있다면 끝까지 체크
 * 경사로 겹치는 조건 확인
 */

import java.io.*;
import java.util.*;

public class SWEA_4014_활주로건설 {
	static int N, X, Ans;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				checkRow(i);
				checkCol(i);
			}
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void checkCol(int c) {
		boolean set = false;
		for (int i = 0; i < N-1; i++) {
			int diff = map[i+1][c] - map[i][c];
			if(Math.abs(diff)>1) return;
			else if(diff == 1) {
				if(i+1-X < 0) return; // 경사로가 범위 밖으로 나감
				int h = map[i][c];
				if(set && i+1 - (2*X) < 0) return;
				for (int j = set==true?i+1-(2*X):i+1-X; j <= i; j++) {
					if(map[j][c] != h) return;
				}
				set = false;
			}
			else if(diff == -1) {
				if(i+X >= N) return;
				int h = map[i+1][c];
				for (int j = i+1; j <= i+X; j++) {
					if(map[j][c] != h) return;
				}
				set = true;
			}
		}
		Ans++;
	}
	private static void checkRow(int r) {
		boolean set = false;
		for (int i = 0; i < N-1; i++) {
			int diff = map[r][i+1] - map[r][i];
			if(Math.abs(diff)>1) return; // 경사 차이가 2칸 이상 나서 경사로 설치 불가능
			else if(diff == 1) { // 올라가는 경사로
				if(i+1-X < 0) return; // 경사로가 범위 밖으로 나감
				int h = map[r][i];
				if(set && i+1 - (2*X) < 0) return;
				for (int j = set==true?i+1-(2*X):i+1-X; j <= i; j++) {
					if(map[r][j] != h) return; // 경사로를 설치하려는데 높이가 평탄하지 않음
				}
				set = false;
			}
			else if(diff == -1) { // 내려가는 경사로
				if(i+X >= N) return;
				int h = map[r][i+1];
				for (int j = i+1; j <= i+X; j++) {
					if(map[r][j] != h) return;
				}
				set = true;
			}
		}
		Ans++;
	}
}
