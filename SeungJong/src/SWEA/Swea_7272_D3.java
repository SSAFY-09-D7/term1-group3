package SWEA;

import java.util.Scanner;

public class Swea_7272_D3 {
	static int T;
	static String S1, S2;
	static String Check1 = "-B";
	static String Check2 = "-ADOPQR";
	static String Check3 = "-CEFGHIJKLMNSTUVWXYZ";
	static String ans;
	static boolean isSame;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = "SAME";
			S1 = sc.next();
			S2 = sc.next();
			if(S1.length() == S2.length()) {
				for (int i = 0; i < S1.length(); i++) {
					isSame = false;
					if(Check1.indexOf(S1.charAt(i))>0) {
						if(Check1.indexOf(S2.charAt(i))>0) {
							isSame = true;
						}						
					}
					if(Check2.indexOf(S1.charAt(i))>0) {
						if(Check2.indexOf(S2.charAt(i))>0) {
							isSame = true;
						}						
					}
					if(Check3.indexOf(S1.charAt(i))>0) {
						if(Check3.indexOf(S2.charAt(i))>0) {
							isSame = true;
						}						
					}
					if(!isSame) {
						ans = "DIFF";
						break;
					}
				}
			} else ans="DIFF";
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}

}
