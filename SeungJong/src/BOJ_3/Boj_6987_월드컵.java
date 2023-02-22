package BOJ_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_6987_월드컵 {

	static int[][] game = new int[4][18];
	static int[][] map1;
	static int[][] map2;
	static int[][] map3;
	static int[][] map4;
	static ArrayList<Point> list = new ArrayList<Point>();
	static StringBuilder sb = new StringBuilder();
	static boolean flag = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setMap();
		combination(new int[2], 0, 0);
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += map1[i][0] + map1[i][1] + map1[i][2];
		}
		if(sum == 30) {
			dfs(map1, 0);
			if(flag) sb.append("1 ");
			else sb.append("0 ");			
		}else sb.append("0 ");
		sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += map2[i][0] + map2[i][1] + map2[i][2];
		}
		if(sum == 30) {
			flag = false;
			dfs(map2, 0);
			if(flag) sb.append("1 ");
			else sb.append("0 ");			
		} else sb.append("0 ");
		sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += map3[i][0] + map3[i][1] + map3[i][2];
		}
		if(sum == 30) {
			flag = false;
			dfs(map3, 0);
			if(flag) sb.append("1 ");
			else sb.append("0 ");			
		} else sb.append("0 ");
		sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += map4[i][0] + map4[i][1] + map4[i][2];
		}
		if(sum == 30) {
			flag = false;
			dfs(map4, 0);
			if(flag) sb.append("1 ");
			else sb.append("0 ");			
		} else sb.append("0 ");
		System.out.println(sb);

	}
	private static void dfs(int[][] map, int count) {
		if(count == list.size()) {
			flag = true;
			return;
		}
		int team1 = list.get(count).team1;
		int team2 = list.get(count).team2;
		if(map[team1][0] > 0 && map[team2][2] >0) {
			map[team1][0] --; map[team2][2]--;
			dfs(map, count+1);
			map[team1][0] ++; map[team2][2]++;
		}
		if(map[team1][2] > 0 && map[team2][0] >0) {
			map[team1][2] --; map[team2][0]--;
			dfs(map, count+1);
			map[team1][2] ++; map[team2][0]++;
		}
		if(map[team1][1] > 0 && map[team2][1] >0) {
			map[team1][1] --; map[team2][1]--;
			dfs(map, count+1);
			map[team1][1] ++; map[team2][1]++;
		}
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k == sel.length) {
			list.add(new Point(sel[0], sel[1]));
			return;
		}
		for (int i = idx; i < 6; i++) {
			sel[k] = i;
			combination(sel, i+1, k+1);
		}
	}
	private static void setMap() {
		map1 = new int[6][3];
		map2 = new int[6][3];
		map3 = new int[6][3];
	    map4 = new int[6][3];
		int index = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				map1[i][j] = game[0][index++];
			}
		}
		index = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				map2[i][j] = game[1][index++];
			}
		}
		index = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				map3[i][j] = game[2][index++];
			}
		}
		index = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				map4[i][j] = game[3][index++];
			}
		}
	}
	
	private static class Point{
		int team1, team2;

		public Point(int team1, int team2) {
			super();
			this.team1 = team1;
			this.team2 = team2;
		}
	}

}
