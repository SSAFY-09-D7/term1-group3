package BOJ_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_16943_숫자재배치 {

	static String str;
	static String[] arr;
	static int maxVal;
	static int ans = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		maxVal = Integer.parseInt(st.nextToken());
		arr = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i,i+1);
		}
		permutation( 0, new boolean[str.length()], new String[str.length()]);
		System.out.println(ans);
		
	}
	private static void permutation(int k, boolean[] v, String[] sel) {
		if(k == v.length ) {
			String temp = "";
			for (int i = 0; i < sel.length; i++) {
				temp += sel[i];
			}
			int t = Integer.parseInt(temp);
			if(Integer.toString(t).length() == str.length()) {
				if(Integer.parseInt(temp) < maxVal) {
					ans = Math.max(ans, Integer.parseInt(temp));
				}				
			}
			return;
		}
		for (int i = 0; i < v.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				permutation(k+1, v, sel);
				v[i] = false;
			}
		}
	}

}
