package BOJ.BOJ4;

import java.io.*;
import java.util.*;

public class BOJ_1759_암호만들기 {
	static int L, C;
	static char[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		combination(new char[L], 0, 0);
	}
	private static void combination(char[] sel, int k, int idx) {
		if(k == sel.length) {
			check(sel);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(sel, k+1, i+1);
		}
	}
	private static void check(char[] sel) {
		int cntVowels = 0;
		int cntConsonants = 0;
		String str ="";
		for (int i = 0; i < sel.length; i++) {
			str += sel[i];
			if(sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' || sel[i] == 'o' || sel[i] == 'u') cntVowels++;
			else cntConsonants++;
		}
		if(cntVowels >= 1 && cntConsonants >= 2) System.out.println(str);
	}
}
