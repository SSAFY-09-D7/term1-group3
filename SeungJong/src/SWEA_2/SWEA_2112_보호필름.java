package SWEA.SWEA2;

/*
 * 두께 D중에서 K를 뽑는 부분집합
 * 한 열씩 검사해서 K개를 만족 못한다면 패스
 * 만족한다면 최소값 
 * 약품 A와 B 테스트...
 */

import java.io.*;
import java.util.*;

public class SWEA_2112_보호필름 {
	static int D, W, K, Ans;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static boolean flag;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			flag = false;
			Ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			powerset(0, new boolean[D]);
			sb.append("#"+tc+" "+Ans+"\n");
		}
		System.out.println(sb);
	}
	private static void powerset(int k, boolean[] v) {
		if(k == v.length) {
			flag = false;
			ArrayList<Integer> change = new ArrayList<Integer>();
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					change.add(i);
				}
			}
			int[][] arr = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = map[i][j];
				}
			}
			solve(0, change, arr);
			if(flag) {
				Ans = Math.min(Ans, change.size());
			}
			return;
		}
		v[k] = false;
		powerset(k+1, v);
		v[k] = true;
		powerset(k+1, v);
	}
	private static void solve(int i, ArrayList<Integer> change, int[][] arr) {
		if(i == change.size()) {
			calc(arr);
			return;
		}
		int r = change.get(i);
		for (int c = 0; c < W; c++) {
			arr[r][c] = 0;
		}
		solve(i+1, change, arr);
		for (int c = 0; c < W; c++) {
			arr[r][c] = 1;
		}
		solve(i+1, change, arr);
	}
	private static void calc(int[][] map) {
		for (int j = 0; j < W; j++) {
			boolean check = false;
			int cnt = 0;
			for (int i = 0; i < D-1; i++) {
				if(map[i][j] == map[i+1][j]) cnt++;
				else cnt = 0;
				if(cnt==K-1) {
					check = true;
					break;
				}
			}
			if(!check) return;
		}
		flag = true;
	}
}
