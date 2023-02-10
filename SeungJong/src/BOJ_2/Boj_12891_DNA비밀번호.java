package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891_DNA비밀번호 {
	
	static int P, S;
	static int[] DNACont = new int[4];
	static int ans = 0;
	static int[] num = new int[4];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			DNACont[i] = Integer.parseInt(st.nextToken());
		}
		int moveCount = P-S;
		String temp = str.substring(0,S);
		checkStr(temp);
		ans += checkNum(num);
		for (int i = 1; i <= moveCount; i++) {
			changenum(str.charAt(i-1), str.charAt(i+S-1));
			ans += checkNum(num);
		}
		System.out.println(ans);
	}
	private static void changenum(char c1, char c2) {
		switch (c1) {
		case 'A':
			num[0]--; break;
		case 'C':
			num[1]--; break;
		case 'G':
			num[2]--; break;
		case 'T':
			num[3]--; break;
		}
		switch (c2) {
		case 'A':
			num[0]++; break;
		case 'C':
			num[1]++; break;
		case 'G':
			num[2]++; break;
		case 'T':
			num[3]++; break;
		}
	}
	private static int checkNum(int[] n) {
		for (int i = 0; i < n.length; i++) {
			if(DNACont[i] > n[i]) return 0;
		}
		return 1;
	}
	private static void checkStr(String str) {
		String[] dna = {"A","C","G","T"};
		for (int i = 0; i < 4; i++) {
			String temp = str.replace(dna[i], "");
			num[i] = str.length()-temp.length();
		}
	}
}
