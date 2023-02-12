package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14889_스타트와링크 {

	static int N, Ans = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] team1;
	static int[] team2;
	static int[] sel1 = new int[2];
	static int[] sel2 = new int[2];
	static int sumTeam1;
	static int sumTeam2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		team1 = new int[N/2];
		team2 = new int[N/2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(Ans);
	}
	private static void combination(int idx, int k) {
		if(k==N/2) {
			otherArr();
//			System.out.println("team1: "+Arrays.toString(team1));
//			System.out.println("team2: "+Arrays.toString(team2));
			sumTeam1 = 0;
			sumTeam2 = 0;
			combination2(sel1, team1, 0, 0);
			combination2(sel2, team2, 0, 0);
//			System.out.println("T1: " + sumTeam1);
//			System.out.println("T2: " + sumTeam2);
			Ans = Math.min(Ans, Math.abs(sumTeam1 - sumTeam2));
//			System.out.println();
			return;
		}
		for (int i = idx; i < N; i++) {
			team1[k] = i;
			combination(i+1, k+1);
		}
	}
	private static void combination2(int[] sel, int[] arr, int idx, int k) {
		if(k==2) {
//			System.out.println(Arrays.toString(sel));
			if(arr.equals(team1)) {
				sumTeam1 += calcSum(sel);				
			}
			else {
				sumTeam2 += calcSum(sel);								
			}
			return;
		}
		for (int i = idx; i < team1.length; i++) {
			sel[k] = arr[i];
			combination2(sel, arr, i+1, k+1);
		}
	}
	
	private static int calcSum(int[] sel) {
		int row = sel[0];
		int col = sel[1];
		int ans = arr[row][col] + arr[col][row];
		return ans;
		
	}
	private static void otherArr() {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		int index = 0;
		for (int i = 0; i < team1.length; i++) {
			arrlist.add(team1[i]);
		}
		for (int i = 0; i < N; i++) {
			if(!arrlist.contains(i)) {
				team2[index] = i;
				index++;
			}
		}
	}

}
