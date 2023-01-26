package SWEA;

import java.util.Scanner;

public class Swea_1289_D3 {

	static int T, count;
	static String ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			ans = sc.next();
			count = 0;
			if(ans.charAt(0) == '1') count = 1;
			for(int i=0; i<ans.length()-1; i++) {
				if(ans.charAt(i) != ans.charAt(i+1)) {
					count += 1;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
		
		sc.close();
	}

}
