package SWEA_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_6808_규영이와인영이의카드게임 {

	static int[] arr1 = new int[9];
	static int[] arr2 = new int[9];
	static int win;
	static int lose;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for (int i = 1; i <= 18; i++) {
				boolean check = false;
				for (int j = 0; j < 9; j++) {
					if(i==arr1[j]) {
						check = true;
						break;
					}
				}
				if(!check) arr2[count++] = i;
			}
			permutation(new int[9], 0, 0);	
			System.out.println("#"+tc+" "+lose+" "+win);
		}
	}
	private static void permutation(int[] sel, int k, int flag) {
		if(k == sel.length) {
			int score1 = 0;
			int score2 = 0;
			for (int i = 0; i < sel.length; i++) {
				if(arr1[i] > sel[i]) score1 += arr1[i] + sel[i];
				else score2 += arr1[i] + sel[i];
			}
			if(score1 > score2) lose++;
			else win++;
			return;
		}
		for (int i = 0; i < sel.length; i++) {
			if((flag & (1<<i)) != 0) continue;
			sel[k] = arr2[i];
			permutation(sel, k+1, flag | (1<<i));
		}
	}

}
