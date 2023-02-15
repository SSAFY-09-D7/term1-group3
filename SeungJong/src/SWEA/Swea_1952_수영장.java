package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_1952_수영장 {

	static int[] price = new int[4];
	static int[] month = new int[12];
	static int Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			Ans = price[3];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {  // 0 ~ 11 월
				month[i] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void solve(int idx, int check) {
		if(idx > 11) {
			Ans = Math.min(Ans, check);
			return;
		}
		if(month[idx] > 0) {
			solve(idx+1, check + price[0] * month[idx]);
			solve(idx+1, check + price[1]);
			solve(idx+3, check + price[2]);
		} else {
			solve(idx+1, check);
		}
		
	}


}
