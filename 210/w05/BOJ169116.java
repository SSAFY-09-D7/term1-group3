package w05;

import java.util.*;
import java.io.*;

class Main {	
	static int pi[];
	
	public static void main(String[] args) throws IOException { 
		System.setIn(new FileInputStream("./inputs/input_BOJ169116.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String P = br.readLine();
		pi = new int[P.length()];
				
		System.out.println(KMP(S, P));
	}

	private static int KMP(String S, String P) {
		int j = 0;
	    for (int i = 1; i < P.length(); ++i) {
	        while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
	        if (P.charAt(i) == P.charAt(j)) pi[i] = ++j;
	    }
	    
	    j = 0;
	    for (int i = 0; i < S.length(); ++i) {
	        while (j > 0 && S.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
	        if (S.charAt(i) == P.charAt(j)) {
	            if (j == P.length() - 1) {
	                return 1;
	            }
	            else j++;
	        }
	    }
	    return 0;
	}
}